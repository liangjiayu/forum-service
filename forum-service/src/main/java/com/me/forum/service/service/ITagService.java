package com.me.forum.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.me.forum.dao.modal.Tag;
import com.me.forum.service.dto.TagDto;
import com.me.forum.service.dto.TagPageDto;

public interface ITagService {
    IPage<Tag> list(TagPageDto tagPageDto);

    boolean create(TagDto tagDto);

    boolean update(TagDto tagDto);

    boolean delete(String id);
}
