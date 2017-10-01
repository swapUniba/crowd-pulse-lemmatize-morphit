package com.github.frapontillo.pulse.crowd.lemmatize.morphit.test;

import com.github.frapontillo.pulse.crowd.lemmatize.morphit.MorphITTag;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Francesco Pontillo
 */
public class MorphITTagTest {

    @Test public void testSimpleEquality() {
        assertTrue(MorphITTag.isTagChildOfTag("NOUN", "NOUN"));
    }

    @Test public void testSpecificityWithDerivational() {
        assertTrue(MorphITTag.isTagChildOfTag("NOUN-M", "NOUN"));
    }

    @Test public void testSpecificityWithMultipleDerivational() {
        assertTrue(MorphITTag.isTagChildOfTag("NOUN-M-1", "NOUN"));
    }

    @Test public void testSpecificityWithInflectional() {
        assertTrue(MorphITTag.isTagChildOfTag("NOUN:p", "NOUN"));
    }

    @Test public void testSpecificityWithMultipleInflectional() {
        assertTrue(MorphITTag.isTagChildOfTag("NOUN:p+s", "NOUN"));
    }

    @Test public void testSpecificityWithDerivationalAndInflectional() {
        assertTrue(MorphITTag.isTagChildOfTag("NOUN-M:p", "NOUN"));
    }

    @Test public void testSpecificityWithMultipleDerivationalAndMultipleInflectional() {
        assertTrue(MorphITTag.isTagChildOfTag("NOUN-M-1-2:p+s+f", "NOUN"));
    }

    @Test public void testSpecificityWithHigherComplexity() {
        assertTrue(MorphITTag.isTagChildOfTag("NOUN-M-1-2:p+s+f", "NOUN-M-2:s+p"));
    }

    @Test public void testNonSpecificity() {
        assertFalse(MorphITTag.isTagChildOfTag("NOUN-M-2:s+p", "NOUN-M-1-2:p+s+f"));
    }

}
