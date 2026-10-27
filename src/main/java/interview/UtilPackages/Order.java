package interview.UtilPackages;


import lombok.*;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {

private int orderId;
private List<Product> products;
private List<LineItem> lineItems;

}