package tw.edu.npu.mis;

/*
 * Copyright (c) 2015, STP
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

/**
 *
 * @author STP
 */
public class AlternativeView implements Observer ,Showable{
    private final String mName;
    private final Window mWindow;
    private final Model mModel;
    /**
     * AlternativeView Class Constructor
     * @param name
     * @param window
     * @param model 
     */
    public AlternativeView(String name, Window window, Model model) {
        mName = name;
        mWindow = window;
        mModel = model;
        mModel.attach(this);
    }

    /**
     * Invalidate the view, which indicates it needs to be redrawn later.
     */
    public void invalidate() {
        mWindow.schduleRedraw(this);
    }

    /**
     * Show the content of the model on the console.
     * 輸出字串時執行到AlternativeView會將字串翻轉
     */
    public void onDraw() {
        System.out.println("AlternativeView (" + mName + "): " + new StringBuilder(mModel.getData()).reverse());
    }
    /**
     * 呼叫View中的invalidate方法
     */
    @Override
    public void update(){
        invalidate();
    }

}

