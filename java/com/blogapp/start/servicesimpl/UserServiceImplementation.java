package com.blogapp.start.servicesimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blogapp.start.Dto.PostDto;
import com.blogapp.start.Dto.UserDto;
import com.blogapp.start.entities.Post;
import com.blogapp.start.entities.User;
import com.blogapp.start.exceptions.ResourceNotFoundException;
import com.blogapp.start.reopsotries.PostReposotries;
import com.blogapp.start.reopsotries.UserReposotries;
import com.blogapp.start.services.UserServices;

@Service
@Transactional
public class UserServiceImplementation implements UserServices {
  @Autowired
  ModelMapper modelmapper;
  @Autowired
  UserReposotries userDao;
  @Autowired
  PostReposotries prepo;
	
	@Override
	public UserDto createuser(UserDto udto) {
		 // List<PostDto> postdto = udto.getPostdto();
		//postdto.stream().forEach(p->p.setUser(udto));
		
		
		User user = modelmapper.map(udto, User.class);
		List<Post> post = user.getPost();
	//	post.stream().forEach(po->po.setUser(user));
      for(Post posta:post) {
    	  posta.setUser(user);
      }

		
		userDao.save(user);
		UserDto userdto = modelmapper.map(user, UserDto.class);
		
		
		
		return userdto;
	}

	@Override
	public UserDto finduser(int id) {
		User user = userDao.findById(id).orElseThrow(()-> new ResourceNotFoundException("please enter valid id"));
		 UserDto UserDto = modelmapper.map(user, UserDto.class);
		                    
		return UserDto;
	}

	@Override
	public UserDto updateuser(UserDto user, int id) {
		User user1 = modelmapper.map(user,User.class);
		         User updateUser= userDao.findById(id).orElseThrow(()->new ResourceNotFoundException("please enter valid id"));
		                     
		         updateUser.setName(user1.getName());
		         updateUser.setPassword(user1.getPassword());
		         updateUser.setAbout(user1.getAbout());
		         updateUser.setEmail(user1.getEmail());
		         User save = userDao.save(updateUser);
		         UserDto userdto = modelmapper.map(save,UserDto.class);
		
		
	
		return userdto;
	}

	@Override
	public void deleteuser(int id) {
		 User user= userDao.findById(id).orElseThrow(()->new ResourceNotFoundException("please enter valid id"));
	       userDao.delete(user);
		
	}

	@Override
	public List<UserDto> findalluser() {
		List<User> userlist = userDao.findAll();
		List<UserDto> listuserdto = userlist.stream().map((User)->modelmapper.map(User,UserDto.class)).collect(Collectors.toList());
		
		
		return listuserdto;
	}

}
