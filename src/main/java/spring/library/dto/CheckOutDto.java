package spring.library.dto;


import java.time.LocalDateTime;

public class CheckOutDto {

  private Long checkoutId;
  private LocalDateTime checkoutDate;
  private LocalDateTime dueDate;
  private boolean isReturned;
  private boolean isRenewed;
}
