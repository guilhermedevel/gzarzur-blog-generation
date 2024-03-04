package com.gzarzur.generationblog.domain.services.impl;

import com.gzarzur.generationblog.domain.exceptions.ObjectNotFoundException;
import com.gzarzur.generationblog.domain.models.Post;
import com.gzarzur.generationblog.domain.models.Theme;
import com.gzarzur.generationblog.domain.repository.PostRepository;
import com.gzarzur.generationblog.rest.vo.PostEditRequest;
import com.gzarzur.generationblog.rest.vo.PostRequest;
import com.gzarzur.generationblog.rest.vo.PostResponse;
import com.gzarzur.generationblog.domain.models.User;
import com.gzarzur.generationblog.domain.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final ModelMapper modelMapper;
    private final PostRepository postRepository;

    public PostServiceImpl(ModelMapper modelMapper, PostRepository postRepository) {
        this.modelMapper = modelMapper;
        this.postRepository = postRepository;
    }

    @Override
    public PostResponse create(PostRequest postRequest) {

        var post = Post
                .builder()
                .withTitle(postRequest.getTitle())
                .withText(postRequest.getText())
                .withDate(OffsetDateTime.now(ZoneOffset.UTC))
                .withUser(User.builder().withId(postRequest.getUserId()).build())
                .withTheme(Theme.builder().withId(postRequest.getThemeId()).build())
                .build();

        var postSaved = this.postRepository.save(post);

        return this.modelMapper.map(postSaved, PostResponse.class);

    }

    @Override
    public List<PostResponse> list() {
        var posts = this.postRepository.findAll();
        return posts.stream().map(post -> modelMapper.map(post, PostResponse.class)).toList();
    }

    @Override
    public PostResponse findById(Long id) {
        var post = this.getById(id);
        return this.modelMapper.map(post, PostResponse.class);
    }

    @Override
    public PostResponse edit(PostEditRequest postEditRequest, Long id) {
        var post = this.getById(id);
        this.modelMapper.map(postEditRequest, post);
        var postSaved = this.postRepository.save(post);
        return this.modelMapper.map(postSaved, PostResponse.class);
    }

    @Override
    public void delete(Long id) {
        var theme = this.getById(id);
        this.postRepository.delete(theme);
    }

    private Post getById(Long id) {
        return this.postRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post not found!"));
    }

}
