package com.blogapp.start.servicesimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.TypeCache.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.blogapp.start.Dto.Categorydto;
import com.blogapp.start.Dto.PostDto;
import com.blogapp.start.Dto.UserDto;
import com.blogapp.start.entities.Category;
import com.blogapp.start.entities.Post;
import com.blogapp.start.entities.User;
import com.blogapp.start.exceptions.ResourceNotFoundException;
import com.blogapp.start.reopsotries.Categoryrepostries;
import com.blogapp.start.reopsotries.PostReposotries;
import com.blogapp.start.reopsotries.UserReposotries;
import com.blogapp.start.services.Postserviceinterfes;
@Service
@Transactional
public class PostServiceImplementation implements Postserviceinterfes {
	
	 @Autowired
	   Categoryrepostries catrep;
	   @Autowired
	   ModelMapper modelmap;
	   @Autowired
	   UserReposotries userDao;
	   @Autowired
	   PostReposotries postrepo;

	@Override
	public PostDto createpost(PostDto postdto, int userid, int categoryid) {
		Post post = modelmap.map(postdto,Post.class);
		User user = userDao.findById(userid).orElseThrow(()->new ResourceNotFoundException("notfound"));
		 Category category= catrep.findById(categoryid).orElseThrow(()->new ResourceNotFoundException("notfound"));     
		post.setImage("default.png");
		post.setUser(user);
		post.setCategory(category);
		postrepo.save(post);
		return modelmap.map(post, PostDto.class);
	
	}

	@Override
	public PostDto updatepost(PostDto postdto, int id) {
		                  Post post = postrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("notfound"));
		                    post.setTitle(postdto.getTitle());
		                    post.setContent(postdto.getContent());
		                    post.setImage("default.jpg");
		                    Post save = postrepo.save(post);
		                    
		                    
		                    
		                    
		                    
		
		
		
		return modelmap.map(save,PostDto.class);
	}

	@Override
	public PostDto getpost(int postid) {
		 Post post = postrepo.findById(postid).orElseThrow(()->new ResourceNotFoundException("notfound"));
		 return modelmap.map(post,PostDto.class);
	}

	@Override
	public List<PostDto> getallpost(int pagenumber,int pagesize,String sortvalue) {
	
		          PageRequest pg= PageRequest.of(pagenumber,pagesize,org.springframework.data.domain.Sort.by(sortvalue));
		                   Page<Post> findAll = postrepo.findAll(pg);
		
		      List<Post> content = findAll.getContent();
		List<PostDto> collect = content.stream().map(post->modelmap.map(post,PostDto.class)).collect(Collectors.toList());
		return collect;
	}

	@Override
	public void deletepostbyid(Integer id) {
		 Post post = postrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("notfound"));
		 postrepo.delete(post);

	}

	@Override
	public List<PostDto> getallpostbuuser(int userid) {

		User user = userDao.findById(userid).orElseThrow(()->new ResourceNotFoundException("notfound"));
		List<Post> listofpost = postrepo.findByUser(user);
	//	List<Post> collect = listofpost.stream().filter(p->).collect(Collectors.toList());
	List<PostDto> listofpostofuser =listofpost.stream().map(post->modelmap.map(post,PostDto.class)).collect(Collectors.toList());
	
	
		return listofpostofuser;
	}

	@Override
	public List<PostDto> getallpostbYCATEGORY(Categorydto userdto) {
		    Category category = modelmap.map(userdto, Category.class);
		    List<Category> listofpost = postrepo.findByCategory(category);
		    List<Category> collect = listofpost.stream().filter(p->p.getCategory()!=p.getCategory()).collect(Collectors.toList());
		
			List<PostDto> listofpostofuser = collect.stream().map(post->modelmap.map(post,PostDto.class)).collect(Collectors.toList());
			
			
			return listofpostofuser;
	}

}
