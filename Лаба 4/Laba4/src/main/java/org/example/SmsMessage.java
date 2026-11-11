package org.example;

// @Getter
// @Setter
public class SmsMessage {
    private String phone;
    private String message;

    public SmsMessage(String phone, String message) {
        this.phone = phone;
        this.message = message;
    }

    public String getPhone() { return phone; }
    public String getMessage() { return message; }
}
