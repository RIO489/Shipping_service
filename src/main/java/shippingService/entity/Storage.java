package shippingService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storageID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger shopID;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger productID;
    @Column(name = "available")
    private Boolean available;
}
