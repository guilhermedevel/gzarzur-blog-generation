package com.gzarzur.generationblog.domain.services.impl;

import com.gzarzur.generationblog.domain.exceptions.ObjectNotFoundException;
import com.gzarzur.generationblog.domain.models.Theme;
import com.gzarzur.generationblog.domain.repository.ThemeRepository;
import com.gzarzur.generationblog.rest.vo.ThemeRequest;
import com.gzarzur.generationblog.rest.vo.ThemeResponse;
import com.gzarzur.generationblog.domain.services.ThemeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {

    private final ModelMapper modelMapper;
    private final ThemeRepository themeRepository;

    public ThemeServiceImpl(ModelMapper modelMapper, ThemeRepository themeRepository) {
        this.modelMapper = modelMapper;
        this.themeRepository = themeRepository;
    }

    @Override
    public ThemeResponse create(ThemeRequest themeRequest) {

        var theme = this.modelMapper.map(themeRequest, Theme.class);

        var themeSaved = this.themeRepository.save(theme);

        return this.modelMapper.map(themeSaved, ThemeResponse.class);

    }

    @Override
    public List<ThemeResponse> list() {
        var themes = this.themeRepository.findAll();
        return themes.stream().map(theme -> modelMapper.map(theme, ThemeResponse.class)).toList();
    }

    @Override
    public ThemeResponse findById(Long id) {
        var theme = this.getById(id);
        return this.modelMapper.map(theme, ThemeResponse.class);
    }

    @Override
    public ThemeResponse edit(ThemeRequest themeRequest, Long id) {
        var theme = this.getById(id);
        this.modelMapper.map(themeRequest, theme);
        var themeSaved = this.themeRepository.save(theme);
        return this.modelMapper.map(themeSaved, ThemeResponse.class);
    }

    @Override
    public void delete(Long id) {
        var theme = this.getById(id);
        this.themeRepository.delete(theme);
    }

    private Theme getById(Long id) {
        return this.themeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Theme not found!"));
    }

}
