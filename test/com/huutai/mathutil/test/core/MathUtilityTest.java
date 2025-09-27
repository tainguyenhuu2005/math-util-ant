/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.huutai.mathutil.test.core;

import com.huutai.mathutil.core.MathUtil;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DLCD
 */
public class MathUtilityTest {
    
    //đây là class sẽ sử dụng các hàm của thư viện/framework JUnit
    //để kiểm thử/kiểm tra code chính - hàm tínhGiaiThừa() bên class core.MathUitl
    //viết code để test code chính bên kia!!!
    
    
    //có nhiều quy tắc đặt tên hàm kiểm thử
    //nhưng thường sẽ là nói lên mục đích của các case/tình huống kiểm thử
    //tình huống xài hàm theo kiểu thành công và thất bại!!!
    
    //hàm dưới đây là tình huống test hàm chạy thành công, trả về ngon
    //ta sẽ xài hàm kiểu well - đưa 5!, 6!, ko chơi -5!, 30!,...
    
    //@Test JUnit sẽ phối hợp với JVM để chạy hàm này
    //@Test phía hậu trường chính là public static void main()
    //Có nhiều @Test ứng với nhiều case khác nhau để kiểm thử hàm tính giai thừa
    @Test
    public void testGetFactorialGivenArgumentReturnsWell() {
        int n = 0; //test thử tình huống tử tế đầu vào, mày phải chạy đúng
        long expected = 1;  //hy vọng 0! = 1
        //long actual = ; //gọi hàm cần test bên core/app chính/code chính
        long actual = MathUtil.getFactorial(n);
        
        //so sánh Expected vs. Actual dùng xanh xanh đỏ đỏ, framework
        assertEquals(expected, actual);
        
        //có thể gộp thêm vài case thành công/đưa đầu vào ngon!!!hàm phải tính ngon
        assertEquals(1, MathUtil.getFactorial(0)); //tui mún 0! == 1
        assertEquals(1, MathUtil.getFactorial(1)); //tui mún 1! == 1
        assertEquals(2, MathUtil.getFactorial(2)); //tui mún 2! == 2
        assertEquals(6, MathUtil.getFactorial(3)); //tui mún 3! == 6
        assertEquals(24, MathUtil.getFactorial(4)); //tui mún 4! == 24
        assertEquals(120, MathUtil.getFactorial(5)); //tui mún 5! == 120
        assertEquals(720, MathUtil.getFactorial(6)); //tui mún 6! == 720
        
        //hàm giúp so sánh 2 giá trị nào đó có giống nhau ko
        //nếu giống -> thảy màu xanh, code ngon - ít nhất cho case đang test
                     
        //nếu ko giống -> thảy màu đỏ - hàm ý expected và actual ko giống nhau
        
    }
    
    
    //hàm getF() ta thiết kế có 2 tình huống xử lí
    //1. đưa data tử tế trong [0...20] -> tính đúng đc n! - done
    //2. đưa data vào cà chớn, âm, > 20; THIẾT KẾ CỦA HÀM LÀ NÉM RA NGOẠI LỆ
    //TUI KÌ VỌNG NGOẠI LỆ XUẤT HIỆN KHI N < 0 || N > 20
    //rất mong ngoại lệ xuất hiện với n cà chớn này 
    
    //nếu hàm nhận vào n < 0 hoặc n > 20 thì hàm ném ra ngoại lệ
    //HÀM CHẠY ĐÚNG NHƯ THIẾT KẾ -> XANH PHẢI XUẤT HIỆN
    
    //nếu hàm nhận vào n < 0 hoặc n > 20 mà hàm ko ném ra ngoại lệ
    //SURE, HÀM CHẠY SAI THIẾT KẾ, SAI KÌ VỌNG, MÀU ĐỎ
    
    //Test case:
    //input: -5
    //expected: IllegalArguentException xuất hiện
    //tình huống bất thường, ngoại lệ, ngoài dự tính, dự liệu
    //là những thứ ko thể đo lường, so sánh theo kiểu value
    //mà chỉ có thể đo lường = cách chúng có xuất hiện hay ko
    //assertEquals() ko dùng để so sánh 2 ngoại lệ
    //      equals() là bằng nhau hay ko trên value!!!
    @Test(expected = IllegalArgumentException.class)
    public void testGetFactorialGivenInvalidArgumentThrowsException() {
        MathUtil.getFactorial(-5); //@Test chạy, hay hàm getF() chạy
    }
    
    
    //cách khác để bắt ngoại lệ xuất hiện, viết tự nhiên hơn!!!
    //xài lambda
    //Test case: hàm sẽ ném về ngoại lệ nếu nhận vào 21
    //tui cần thấy màu xanh khi chơi với 21!
    @Test
    public void testGetFactorialGivenInvalidArgumentThrowsException_LambdaVersion() {
        //assertThrows(tham số 1: loại ngoại lệ mún so sánh, 
        //             tham số 2: đoạn code chạy văng ra ngoại lệ đó);
        
        assertThrows(IllegalArgumentException.class, () -> MathUtil.getFactorial(-5));
        
    }
    
    
    //Bắt ngoại lệ, xem hàm có ném về ngoại lệ hay không khi n cà chớn
    //có ném, tức là hàm chạy đúng thiết kế -> xanh
    @Test
    public void testGetFactorialGivenInvalidArgumentThrowsException_TryCatch() {
        
        //chủ động kiểm soát ngoại lệ!!!
        try {
            MathUtil.getFactorial(-5);
        } catch (Exception e) {
            //bắt try-catch là JUnit sẽ ra xanh do đã chủ động kiểm soát ngoại lệ
            //nhưng ko chắc ngoại lệ mình cần có xuất hiện hay ko
            //có đoạn code kiểm soát đúng ngoại lệ IllegalArgumentException xuất hiện
            assertEquals("Invalid argument. N must be between 0 ... 20", e.getMessage());
            
        }
    }
}
