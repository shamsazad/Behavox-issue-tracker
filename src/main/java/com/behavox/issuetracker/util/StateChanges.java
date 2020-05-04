package com.behavox.issuetracker.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StateChanges {

    @SafeVarargs
    public static <T extends Enum> void addAsValid(Map<T, Set<T>> stateMap, T currentState, T... futureStates) {

        stateMap.putIfAbsent(currentState, new HashSet<T>());
        stateMap.get(currentState).addAll(Arrays.asList(futureStates));
    }

    public static <T extends Enum> boolean transitionIsValid(Map<T, Set<T>> stateMap, T currentState, T futureState) {
        if (currentState.equals(futureState)) {
            return true;
        }

        Set<T> validStates = stateMap.get(currentState);
        return validStates != null && validStates.contains(futureState);
    }

}
