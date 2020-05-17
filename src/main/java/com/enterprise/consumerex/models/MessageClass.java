package com.enterprise.consumerex.models;

public class MessageClass {

  private String Message;
  private String Description;

  public MessageClass(String message, String description) {
    Message = message;
    Description = description;
  }

  public String getMessage() {
    return Message;
  }

  public void setMessage(String message) {
    Message = message;
  }

  public String getDescription() {
    return Description;
  }

  public void setDescription(String description) {
    Description = description;
  }

  @Override
  public String toString() {
    return "MessageClass{" +
            "Message='" + Message + '\'' +
            ", Description='" + Description + '\'' +
            '}';
  }
}
