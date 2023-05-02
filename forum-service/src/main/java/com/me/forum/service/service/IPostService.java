package com.me.forum.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.forum.dao.modal.Post;
import com.me.forum.service.dto.PostDto;
import com.me.forum.service.dto.PostPageDto;

public interface IPostService {
    IPage<Post> list(PostPageDto postPageDto);

    boolean create(PostDto postDto);

    boolean update(PostDto postDto);

    boolean delete(String id);
}
