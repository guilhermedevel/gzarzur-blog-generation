package com.gzarzur.generationblog.domain.services;

import com.gzarzur.generationblog.rest.vo.PostEditRequest;
import com.gzarzur.generationblog.rest.vo.PostRequest;
import com.gzarzur.generationblog.rest.vo.PostResponse;

import java.util.List;

public interface PostService {
    PostResponse create(PostRequest postRequest);

    List<PostResponse> list();

    PostResponse findById(Long id);

    PostResponse edit(PostEditRequest postEditRequest, Long id);

    void delete(Long id);
}