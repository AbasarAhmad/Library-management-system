package DTO;

import com.backendProject.library_management_system.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BookRequestDto {
    private String title;
    private int price;
    private Genre genre;
    private int authorId;
}
