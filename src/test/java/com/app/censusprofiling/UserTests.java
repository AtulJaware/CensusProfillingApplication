package com.app.censusprofiling;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.app.censusprofiling.entity.User;
import com.app.censusprofiling.exception.UserAlreadyExistsException;
import com.app.censusprofiling.exception.UserNotFoundException;
import com.app.censusprofiling.services.IUserService;

@ExtendWith(MockitoExtension.class)
public class UserTests {

	@Mock
	IUserService iUserService;

	@Test
	void addUserTest() throws UserAlreadyExistsException {
		User user = new User(1,"name1","name2",LocalDate.parse("2022-12-12"),"8790012308");
		when(iUserService.addUser(user)).thenReturn(user);
		assertEquals(iUserService.addUser(user),user);
	}
	
	@Test
	void getUserTest() throws UserNotFoundException {
		User user = new User(1,"name1","name2",LocalDate.parse("2022-12-12"),"8790012308");
		Optional<User> OUserEntity = Optional.of(user);
		when(iUserService.getUser(1)).thenReturn(OUserEntity);
		assertEquals(iUserService.getUser(1).get(),user);
	}
	
	@Test
	void updateUserTest() throws UserNotFoundException {
		User user = new User(1,"name1","name2",LocalDate.parse("2022-12-12"),"8790012308");
		when(iUserService.updateUser(1,user)).thenReturn(user);
		assertEquals(iUserService.updateUser(1,user),user);
	}
	
	@Test
	void deleteUserTest() throws UserNotFoundException {
		User user = new User(1,"name1","name2",LocalDate.parse("2022-12-12"),"8790012308");
		Optional<User> OUserEntity = Optional.of(user);
		when(iUserService.deleteUser(1)).thenReturn(OUserEntity);
		assertEquals(iUserService.deleteUser(1).get(),user);
	}

}

