package dtos;

import data.entity.Role;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Builder
@Data
public class UserDto {
  private Long id;
  private String username;
  private Role role;
}
