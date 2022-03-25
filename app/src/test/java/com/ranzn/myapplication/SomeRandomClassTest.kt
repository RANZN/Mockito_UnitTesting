package com.ranzn.myapplication

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.Spy
import org.mockito.junit.MockitoJUnitRunner
import java.util.*


@RunWith(MockitoJUnitRunner::class)
class SomeRandomClassTest {

    //Using ArrayList as a class for testing and its method .get() .size() as some class Method..
    @Mock
    private lateinit var list: ArrayList<Int>


    @Spy
    private lateinit var spyList: ArrayList<String>

    @Before
    fun before() {
//        val list = Mockito.mock(List::class.java)
    }

    @Test
    fun `interface testing`() {
        `when`(list.size).thenReturn(10)
        assertEquals(10, list.size)
    }

    @Test
    fun `multiple Returns`() {
        `when`(list.size).thenReturn(10).thenReturn(20)
        assertEquals(10, list.size)
        assertEquals(20, list.size)
        //If doing more aseert method then it will return the last value
        assertEquals(20, list.size)
    }


    @Test
    fun `With some inputs`() {
        `when`(list.get(0)).thenReturn(10)
        assertEquals(10, list.get(0))
        assertEquals(null, list.get(1))
    }

    @Test
    fun `defining random`() {
        //Mockito has inbuilt any() methods of all type where we can define it randomly
        `when`(list.get(anyInt())).thenReturn(10)
        assertEquals(10, list.get(0))
        assertEquals(10, list.get(1))
        assertEquals(10, list.get(2))
        assertEquals(10, list.get(3))
        assertEquals(10, list.get(4))
        assertEquals(10, list.get(10000))

    }

    @Test
    fun randomChecks() {
        verify(list, times(0)).size
        list.add(10)
        verify(list).add(10)
        verify(list).add(anyInt())

    }

    @Test
    fun `abcd`() {
        list.size
        verify(list, never()).clear()
    }


    @Test
    fun `spy test`() {

        spyList.add("Some random text one")
        verify(spyList).add("Some random text one")

        assertEquals(1, spyList.size)
    }



    /**
     * Error handling Mockito
     */
    private lateinit var dummyList: ArrayList<Int>
    @Test(expected = UninitializedPropertyAccessException::class)
    fun `error test`() {
        `when`(dummyList.size).thenReturn(1)
    }

    @Test(expected = NullPointerException::class)
    fun `error test null pointer`() {
        `when`(list.size).thenThrow(NullPointerException::class.java)
        list.size
    }


    

}