package lk.ijse.gdse.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString


public class Payment {
    private String Payment_id;
    private String Payment_date;
    private String Payment_Time;
    private String Payment_Amount;
    private String Student_id;
    private String Payment_Holders_Name;
    private String Payment_Holders_UserName;
}
