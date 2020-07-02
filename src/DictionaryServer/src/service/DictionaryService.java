package service;

import java.util.Map;

/**
 * @name Ruofan
 * @surname Zhang
 * @studentID 1029050
 */

public interface DictionaryService {
    String query(String word, Map<String, String> hashMap);
    String addWord(String word, String meaning, Map<String, String> hashMap);
    String removeWord(String word, Map<String, String> hashMap);
}
