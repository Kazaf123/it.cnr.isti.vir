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
package it.cnr.isti.vir.classification;

import it.cnr.isti.vir.similarity.results.ISimilarityResults;

public class PredictedLabelWithSimilars extends PredictedLabel {

	private final ISimilarityResults<?> res;
	
//	public PredictedClassLabelWithSimilars(ClassLabel cLabel, double confidence) {
//		super(cLabel, confidence);
//		res = null;
//	}

	public PredictedLabelWithSimilars(AbstractLabel cLabel, double confidence, ISimilarityResults<?> res) {
		super(cLabel, confidence);
		this.res = res;
	}
	
	public PredictedLabelWithSimilars(PredictedLabel prLabel, ISimilarityResults<?> res) {
		super(prLabel);
		this.res = res;
	}
	
	public final ISimilarityResults<?> getResults() {
		return res;
	}

	public PredictedLabel getPredictedLabelOnly() {
		return new PredictedLabel(cLabel, confidence);
	}
	
}
