package com.ranzn.myapplication

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class CalculatorTest {
    /*
     * For Mocking use the latest dependency coz in older mocking final class was mess.
     *
     * If want to verify some method or function which returning output the we should call that method we different parameters then should verify it with mocking object
     *
     * If we have some interface or some database then we cannot modify it to return or do some things in that case use when().thenReturn()  and then assertThat.
     *
     */


    /**
     * We can use @Mock as done at 1 or we can initilize it as done at 2 both are the ways...
     * 3rd is the way for JUNit/ Stub   for creating instance.
     */


    /**1*/
    @Mock
    private lateinit var calculator: Calculator

    @Before
    fun onSetup() {
        /**2*/
//        calculator = mock(Calculator::class.java)
        /**3*/
//        calculator = Calculator()
    }

    @Test
    fun `add two numbers`() {
        val a = 10
        val b = 10
        val data = calculator.add(a, b)
        verify(calculator).add(a, b)
    }

    @Test
    fun `sub two numbers`() {
        val a = 10
        val b = 40
//        `when`(calculator.sub(a, b)).thenReturn(5)
        calculator.sub(a, b)
        verify(calculator).sub(a, b)
//        assertEquals(5, data)
    }

    @Test
    fun `concat`() {
        val a = "abcd"
        val b = "efgh"
//        `when`(calculator.concat(a, b)).thenReturn(calculator.concat(a, b))
        val data = calculator.concat(a, b)
//        assertEquals("abcdefgh", data)
        verify(calculator).concat(a, b)
    }


}