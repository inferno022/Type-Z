/*
 * Copyright (C) 2024 FUTO Keyboard Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.futo.inputmethod.keyboard.internal;

import android.util.Log;
import android.view.MotionEvent;

import org.futo.inputmethod.keyboard.Key;
import org.futo.inputmethod.latin.common.Constants;

/**
 * Handles swipe gestures for specific keys like space bar and delete key.
 * Provides cursor movement and mass delete functionality.
 */
public class SwipeGestureHandler {
    private static final String TAG = SwipeGestureHandler.class.getSimpleName();
    
    // Minimum distance in pixels to trigger a swipe gesture
    private static final int MIN_SWIPE_DISTANCE = 30;
    
    // Distance thresholds for different swipe actions
    private static final int CURSOR_MOVE_THRESHOLD = 20;
    private static final int WORD_DELETE_THRESHOLD = 40;
    
    private int mStartX = -1;
    private int mStartY = -1;
    private Key mStartKey = null;
    private boolean mIsSwipeInProgress = false;
    private SwipeGestureListener mListener;
    
    public interface SwipeGestureListener {
        void onCursorMoveLeft();
        void onCursorMoveRight(); 
        void onWordDelete();
        void onLineDelete();
    }
    
    public SwipeGestureHandler(SwipeGestureListener listener) {
        mListener = listener;
    }
    
    /**
     * Start tracking a potential swipe gesture on a key
     */
    public void startSwipe(Key key, int x, int y) {
        if (isSwipeKey(key)) {
            mStartKey = key;
            mStartX = x;
            mStartY = y;
            mIsSwipeInProgress = true;
        }
    }
    
    /**
     * Handle move events during a potential swipe
     */
    public boolean handleMove(int x, int y) {
        if (!mIsSwipeInProgress || mStartKey == null) {
            return false;
        }
        
        int deltaX = x - mStartX;
        int deltaY = y - mStartY;
        int absDeltaX = Math.abs(deltaX);
        int absDeltaY = Math.abs(deltaY);
        
        // Check if we've moved enough to trigger a swipe
        if (absDeltaX < MIN_SWIPE_DISTANCE && absDeltaY < MIN_SWIPE_DISTANCE) {
            return false;
        }
        
        // Determine the swipe direction and action
        if (isSpaceKey(mStartKey)) {
            return handleSpaceBarSwipe(deltaX, deltaY, absDeltaX, absDeltaY);
        } else if (isDeleteKey(mStartKey)) {
            return handleDeleteKeySwipe(deltaX, deltaY, absDeltaX, absDeltaY);
        }
        
        return false;
    }
    
    /**
     * End swipe tracking
     */
    public void endSwipe() {
        mStartKey = null;
        mStartX = -1;
        mStartY = -1;
        mIsSwipeInProgress = false;
    }
    
    private boolean isSwipeKey(Key key) {
        return isSpaceKey(key) || isDeleteKey(key);
    }
    
    private boolean isSpaceKey(Key key) {
        return key != null && key.getCode() == Constants.CODE_SPACE;
    }
    
    private boolean isDeleteKey(Key key) {
        return key != null && key.getCode() == Constants.CODE_DELETE;
    }
    
    private boolean handleSpaceBarSwipe(int deltaX, int deltaY, int absDeltaX, int absDeltaY) {
        // Only handle horizontal swipes on space bar
        if (absDeltaX < CURSOR_MOVE_THRESHOLD || absDeltaY > absDeltaX) {
            return false;
        }
        
        if (deltaX > 0) {
            mListener.onCursorMoveRight();
        } else {
            mListener.onCursorMoveLeft();
        }
        
        // Reset swipe after triggering action
        endSwipe();
        return true;
    }
    
    private boolean handleDeleteKeySwipe(int deltaX, int deltaY, int absDeltaX, int absDeltaY) {
        // Handle horizontal swipes on delete key for mass delete
        if (absDeltaX < WORD_DELETE_THRESHOLD) {
            return false;
        }
        
        if (absDeltaX > WORD_DELETE_THRESHOLD * 2) {
            mListener.onLineDelete();
        } else {
            mListener.onWordDelete();
        }
        
        // Reset swipe after triggering action
        endSwipe();
        return true;
    }
}
