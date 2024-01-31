package spring.library.controller.response;


public class CheckoutResponse {

    private Long checkOutId;

    private String author;

    private String checkOutDate;

    private String dueDate;

    private int renewalCount;

    private Boolean isReturned;
}

/*
      "checkOutId": 1,
              "title": "인생은 실전이다",
              "author": "김성근",
              "checkOutDate": "2024-01-26",
              "dueDate": "2024-02-05",
              "renewalCount": 0,
              "isReturned": true
              },
*/
