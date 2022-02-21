package com.monthy.hall.tests;

import com.monthy.hall.MonthyHall;
import com.monthy.hall.implementations.BoxSelection;
import org.junit.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

public class MonthyHallTest {

    @Test
    public void testBoxSelection(){
        BoxSelection boxSelection = Mockito.mock(BoxSelection.class);
        when(boxSelection.getUserInputToContPrograme()).thenReturn("Y");

        String result = BoxSelection.boxSelection(1,1,2,3,boxSelection);
        assertEquals("You Lose", result);
    }
}
