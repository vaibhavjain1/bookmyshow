/**
 * 
 */
package com.bms.adapter;

import com.bms.dto.UserDto;
import com.bms.model.UserEntity;

public class UserAdapter {

	public static UserEntity toEntity(UserDto userDto) {

		return UserEntity.builder()
				.name(userDto.getName())
				.mobile(userDto.getMobile())
				.build();

	}

	public static UserDto toDto(UserEntity userEntity) {

		return UserDto.builder()
				.id(userEntity.getId())
				.name(userEntity.getName())
				.mobile(userEntity.getMobile())
				.build();
	}

}