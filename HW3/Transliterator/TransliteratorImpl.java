package HW3.Transliterator;

import java.util.HashMap;

public class TransliteratorImpl implements Transliterator {

    private HashMap<Character, String> translitMap;

    TransliteratorImpl() {
        translitMap = new HashMap<Character, String>();
        translitMap.put('А', "A");
        translitMap.put('Б', "B");
        translitMap.put('В', "V");
        translitMap.put('Г', "G");
        translitMap.put('Д', "D");
        translitMap.put('Е', "E");
        translitMap.put('Ж', "Zh");
        translitMap.put('З', "Z");
        translitMap.put('И', "I");
        translitMap.put('Й', "Y");
        translitMap.put('К', "K");
        translitMap.put('Л', "L");
        translitMap.put('М', "M");
        translitMap.put('Н', "N");
        translitMap.put('О', "O");
        translitMap.put('П', "P");
        translitMap.put('Р', "R");
        translitMap.put('С', "S");
        translitMap.put('Т', "T");
        translitMap.put('У', "U");
        translitMap.put('Ф', "F");
        translitMap.put('Х', "Kh");
        translitMap.put('Ц', "Ts");
        translitMap.put('Ч', "Ch");
        translitMap.put('Ш', "Sh");
        translitMap.put('Щ', "Shch");
        translitMap.put('Ъ', "'");
        translitMap.put('Ы', "Y");
        translitMap.put('Ь', "'");
        translitMap.put('Э', "E");
        translitMap.put('Ю', "Yu");
        translitMap.put('Я', "Ya");
    }

    @Override
    public String transliterate(String source) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if (c >= 'А' && c <= 'Я') {
                String translit = translitMap.get(Character.toUpperCase(c));
                if (translit == null) {
                    translit = "";
                }
                builder.append(translit);
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}