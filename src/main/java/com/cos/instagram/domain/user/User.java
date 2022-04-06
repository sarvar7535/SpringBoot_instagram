package com.cos.instagram.domain.user;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SqlResultSetMapping;

import org.hibernate.annotations.CreationTimestamp;

import com.cos.instagram.web.dto.FollowRespDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SqlResultSetMapping(
		name = "FollowRespDtoMapping",
		classes = @ConstructorResult(
				targetClass = FollowRespDto.class,
				columns = {
						@ColumnResult(name="id", type = Integer.class),
						@ColumnResult(name="username", type = String.class),
						@ColumnResult(name="name", type = String.class),
						@ColumnResult(name="profileImage", type = String.class),
						@ColumnResult(name="followState", type = Boolean.class),
						@ColumnResult(name="equalUserState", type = Boolean.class),
				}
		)
)
@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private String username;
	private String password;
	private String email; // model 만들 때 실수로 안 만듬
	private String name;
	private String website;
	private String bio; // 자기소개
	private String phone;
	private String gender;
	private String profileImage;
	@Enumerated(EnumType.STRING) // DB는 Object 타입이 없기 때문에 타입을 알려줘야한다.
	private UserRole role; // 타입에 강제성이 들어감
	private String provider;
	private String providerId;
	@CreationTimestamp // DB에 insert하면 현재 시간 들어감
	private Timestamp createDate;
	
}
