package service;

/**
 * @name Ruofan
 * @surname Zhang
 * @studentID 1029050
 */

public enum ServiceResultEnum {
    SUCCESS_ADD("Success: word has been added"),
    SUCCESS_REMOVE("Success: word has been removed"),
    DUPLICATE("Error: word already existed"),
    NOT_FOUND("Error: word not found"),
    WORD_MISSED("Error: please enter the word"),
    MEANING_MISSED("Error: please enter the meaning"),
    ILLEGAL_PORT("Error: please enter legal port number"),
    BAD_FILEPATH("Error: can't find the dictionary file"),
    TIME_OUT("Error: server no response, please check host and port");

    private String result;

    ServiceResultEnum(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
