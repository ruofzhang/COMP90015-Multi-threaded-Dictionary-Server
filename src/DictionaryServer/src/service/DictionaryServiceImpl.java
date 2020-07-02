package service;

import java.util.Map;

/**
 * @name Ruofan
 * @surname Zhang
 * @studentID 1029050
 */

public class DictionaryServiceImpl implements DictionaryService {

    @Override
    public String query(String word, Map<String, String> hashMap) {
        String result = ServiceResultEnum.NOT_FOUND.getResult();
        if(hashMap.containsKey(word)){
            result = hashMap.get(word);
        }
        return result;
    }

    @Override
    public String addWord(String word, String meaning, Map<String, String> hashMap) {
        if(hashMap.containsKey(word)){
            return ServiceResultEnum.DUPLICATE.getResult();
        }
        hashMap.put(word, meaning);
        return ServiceResultEnum.SUCCESS_ADD.getResult();
    }

    @Override
    public String removeWord(String word, Map<String, String> hashMap) {
        if(!hashMap.containsKey(word)){
            return ServiceResultEnum.NOT_FOUND.getResult();
        }
        hashMap.remove(word);
        return ServiceResultEnum.SUCCESS_REMOVE.getResult();
    }
}
