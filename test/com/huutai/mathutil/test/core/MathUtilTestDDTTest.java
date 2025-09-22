/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.huutai.mathutil.test.core;

import com.huutai.mathutil.core.MathUtil;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author DLCD
 */

//câu lệnh này của JUnit báo hiệu rằng sẽ cần loop qua tập data để
//lấy các cặp data input/expected nhồi vào các hàm test
@RunWith(value = Parameterized.class)
public class MathUtilTestDDTTest {
    
    //hàm này ta sẽ trả về mảng 2 chiều gồm nhiều cặp Input|Expected
    @Parameterized.Parameters   //JUnit sẽ ngầm chạy loop qua từng dòng của mảng
                                //để lấy ra đc các cặp data input/expected
    //tên hàm ko quan trọng, quan trọng là @
    public static Object[][] initData() {
        return new Integer[][] {
                                    {0, 1},
                                    {1, 1},
                                    {2, 2},
                                    {3, 6},
                                    {4, 24},
                                    {6, 720},
        };
    }
    
    //giả sử đã loop qua từng dòng của mảng, ta vẫn cần gán từng value của cột
    //vào biến tương ứng input/expected để lát hồi feed cho hàm
    
    @Parameterized.Parameter(value = 0)  //value = 0 là map với mảng data
    public int n; //biến map với value của cột 0 của mảng
    
    @Parameterized.Parameter(value = 1)
    public long expected;  //kiểu long vì giá trị trả về của hàm getF()
                           //là long
    
    @Test
    public void testGetFactorialGivenArgumentReturnsWell() {
        assertEquals(expected, MathUtil.getFactorial(n));
    }
}
