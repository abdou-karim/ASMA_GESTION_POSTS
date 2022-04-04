package sn.gestion.post.exception;

public enum ErrorCodes {
  Utilisateur_NOT_FOUND(1000),
  Utilisateur_NOT_VALID(1001),
  Utilisateur_ALREADY_IN_USE(1002),


  POST_NOT_FOUND(2000),
  POST_NOT_VALID(2001),
  POST_ALREADY_IN_USE(2002),

  Transaction_NOT_FOUND(3000),
  Transaction_NOT_VALID(3001),
  POST_NEVER_USED(2003)
  ;


  private int code;

  ErrorCodes(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
