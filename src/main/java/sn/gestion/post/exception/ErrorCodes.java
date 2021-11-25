package sn.gestion.post.exception;

public enum ErrorCodes {
  Utilisateur_NOT_FOUND(1000),
  Utilisateur_NOT_VALID(1001),
  Utilisateur_ALREADY_IN_USE(1002),

  POST_NOT_FOUND(2000),
  POST_NOT_VALID(2001),
  POST_ALREADY_IN_USE(2002),
  ;


  private int code;

  ErrorCodes(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }
}
