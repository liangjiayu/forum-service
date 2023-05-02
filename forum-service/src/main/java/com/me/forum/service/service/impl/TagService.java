package com.me.forum.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.me.forum.dao.mapper.TagMapper;
import com.me.forum.dao.modal.Tag;
import com.me.forum.service.dto.TagDto;
import com.me.forum.service.dto.TagPageDto;
import com.me.forum.service.service.ITagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService extends ServiceImpl<TagMapper, Tag> implements ITagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public IPage<Tag> list(TagPageDto tagPageDto) {
        Page<Tag> page = new Page<>(tagPageDto.getPageNum(), tagPageDto.getPageSize());
        QueryWrapper<Tag> queryWrapper = new QueryWrapper<>();

        return this.tagMapper.selectPage(page, queryWrapper);
    }

    @Override
    public boolean create(TagDto tagDto) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(tagDto, tag);
        tag.setId(null);

        return this.tagMapper.insert(tag) > 0;
    }

    @Override
    public boolean update(TagDto tagDto) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(tagDto, tag);

        return this.tagMapper.updateById(tag) > 0;
    }

    @Override
    public boolean delete(String id) {
        return this.tagMapper.deleteById(id) > 0;
    }
}
