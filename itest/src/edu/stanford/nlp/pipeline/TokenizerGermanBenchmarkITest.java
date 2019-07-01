package edu.stanford.nlp.pipeline;

import java.util.Properties;

public class TokenizerGermanBenchmarkITest extends TokenizerBenchmarkTestCase {

    @Override
    public void setUp() {
        // set up the pipeline
        Properties props = new Properties();
        props.put("annotators", "tokenize,ssplit,mwt");
        props.put("tokenize.language", "de");
        props.put("tokenize.options", "ptb3Escaping=false");
        props.put("mwt.mappingFile",
                "/u/nlp/data/stanford-corenlp/test/data/mwt/de-mwt.tsv");
        pipeline = new StanfordCoreNLP(props);
    }

    public void testOnDev() {
        goldFilePath = "/u/nlp/data/stanford-corenlp/test/data/tokenize/de_gsd-ud-dev.conllu";
        runTest("dev", "de", 0.95);
    }

}