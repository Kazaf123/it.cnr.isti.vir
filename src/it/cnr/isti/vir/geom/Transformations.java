/*******************************************************************************
 * Copyright (c) 2013, Fabrizio Falchi (NeMIS Lab., ISTI-CNR, Italy)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met: 
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 ******************************************************************************/
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package it.cnr.isti.vir.geom;

/**
 *
 * @author Fabrizio
 */
public class Transformations {

    

    public static final Integer getNPointsForEstimation(Class trClass) {
        
        if ( trClass.equals(RSTTransformation.class) ) return 2;
        if ( trClass.equals(AffineTransformation.class) ) return 3;
        if ( trClass.equals(HomographyTransformation.class) ) return 4;
        return null;
    }

    public static final AbstractTransformation getTransformation(Class trClass, float[][] pSrc, float[][] pDest) {
        if ( trClass.equals(AffineTransformation.class) ) {
            return AffineTransformation.getTransformation(pSrc, pDest);
        }
        if ( trClass.equals(HomographyTransformation.class) ) {
            return HomographyTransformation.getTransformation(pSrc, pDest);
        }
        if ( trClass.equals(RSTTransformation.class) ) {
            return RSTTransformation.getTransformation(pSrc, pDest);
        }
        return null;
    }
}
