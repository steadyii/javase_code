package com.steady.d1_primitiveType;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * Unicode 和 char 类型
 * <hr>
 * 在设计 Java 时决定采用 16 位的 Unicode 字符集，这样会比使用 8 位字符集的程序设计语言有很大的改进。
 * 十分遗憾， Unicode 字符超过了 65 536 个，其主要原因是增加了大量的汉语、 日语和韩语中的表意文字。
 * 现在，16 位的 char 类型已经不能满足描述所有 Unicode 字符的需要了。
 * <br><br>
 * 从 Java SE 5.0 开始。码点（ code point) 是指与一个编码表中的某个字符对应的代码值。
 * 在 Unicode 标准中，码点采用十六进制书写，并加上前缀 U+, 例如 U+0041 就是拉丁字母 A 的码点。
 * <br><br>
 * Unicode 的码点可以分成 17 个代码级别(codeplane)。
 * 第一个代码级别称为基本的多语言级别(basicmultilingual plane),
 * 码点从 U+0000 到 U+FFFF, 其中包括经典的 Unicode 代码;<br>
 * 其余的 16个级别码点从 U+10000 到 U+10FFFF, 其中包括一些辅助字符(supplementary character)
 * <br><br>
 * `UTF-16` 编码采用不同长度的编码表示所有 Unicode 码点。在基本的多语言级别中，每个
 * 字符用 16 位表示，通常被称为代码单元（ code unit); <br>
 * 而`辅助字符` 采用一对 `连续的代码单元` 进行编码。
 * 这样构成的编码值落人基本的多语言级别中空闲的 2048 字节内， 通常被称为替代区域（surrogate area) <br>
 * U+D800 ~ U+DBFF 用于第一个代码单元<br>
 * U+DC00 ~ U+DFFF 用于第二个代码单元<br>
 * 这样设计十分巧妙，我们可以从中迅速地知道一个代码单元是一个字符的编码，还是一个辅助字符的第一或第二部分。<br>
 * 在 Java 中，char 类型描述了 UTF-16 编码中的一个代码单元。
 * <hr>
 * 我们强烈建议不要在程序中使用 char 类型，除非确实需要处理 UTF-16 代码单元。最好
 * 将字符串作为抽象数据类型处理。
 */
@SpringBootTest
public class CharTest {

}
