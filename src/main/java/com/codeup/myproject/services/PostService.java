package com.codeup.myproject.services;

import com.codeup.myproject.models.Post;
import com.codeup.myproject.models.PostsRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {


    private final PostsRepository PostDao;

    public PostService(PostsRepository PostDao) {
        this.PostDao = PostDao;
    }


    public List<Post> all() {
        return (List<Post>) PostDao.findAll();
    }

    public Post create(Post post){
        return PostDao.save(post);
    }

    public Post edit(Post post){
       return PostDao.save(post);
    }

    public Post findOne(int id) {
        return PostDao.findOne(id);
    }


    public void delete(Post post) {
        PostDao.delete(post);
    }
}
