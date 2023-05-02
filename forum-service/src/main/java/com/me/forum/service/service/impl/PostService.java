package com.me.forum.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.forum.dao.mapper.PostMapper;
import com.me.forum.dao.modal.Post;
import com.me.forum.service.dto.PostDto;
import com.me.forum.service.dto.PostPageDto;
import com.me.forum.service.service.IPostService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService extends ServiceImpl<PostMapper, Post> implements IPostService {

    @Autowired
    PostMapper postMapper;

    @Override
    public IPage<Post> list(PostPageDto postPageDto) {
        Page<Post> page = new Page<>(postPageDto.getPageNum(), postPageDto.getPageSize());
        QueryWrapper<Post> queryWrapper = new QueryWrapper<>();

        return this.postMapper.selectPage(page, queryWrapper);
    }

    @Override
    public boolean create(PostDto postDto) {
        Post post = new Post();
        BeanUtils.copyProperties(postDto, post);
        post.setId(null);

        return this.postMapper.insert(post) > 0;
    }

    @Override
    public boolean update(PostDto postDto) {
        Post post = new Post();
        BeanUtils.copyProperties(postDto, post);

        return this.postMapper.updateById(post) > 0;
    }

    @Override
    public boolean delete(String id) {
        return this.postMapper.deleteById(id) > 0;
    }
}
