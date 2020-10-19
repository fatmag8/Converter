package converter.EntityFramework;


import lombok.Data;
import javax.persistence.*;

@Table(name = "request_response_table")
@Entity
@Data
public class LinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Response")
    private String response ;

    @Column(name = "Request")
    private String request;

    @Column(name="Request_Response_Type")
    private String type;

    public LinkEntity(String request,String response,String type) {
        this.type=type;
        this.request=request;
        this.response=response;
    }
}
