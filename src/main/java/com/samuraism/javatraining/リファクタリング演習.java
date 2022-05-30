package com.samuraism.javatraining;

@SuppressWarnings("NonAsciiCharacters")
public class リファクタリング演習 {
    public static void main(String[] args) {

        var str2 = """
                テキストブロック
                こんにちは
                """;
        System.out.println(str2);

        Person nobunaga = new Person("織田信長", 47);
        System.out.printf("%s 享年:%d%n", nobunaga.name(), nobunaga.age());
    }
}

record Person(String name, int age) {

}
