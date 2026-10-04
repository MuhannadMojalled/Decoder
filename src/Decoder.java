public class Decoder {
    // Mr.Mojalled's Solution
    public static void main(String[] args) {
        String[] encodedData = {
                "242837435263orangedqhzmvHedybrightyfjLamarrtableobomco-inventedcherrytlrft",
                "262737546571oceanforestorzavalleycofnfrequency-hoppinghousenmiudmspreadpapervfpb",
                "273550607278laptopforestmlaspectrumoceandarkrfrzijtechnologypencilsawimpduringscreenuezw",
                "263142455456screenpaperojrWorldvalleyjllpiWarlightasjtIIswimmingancientzuoj",
                "283246506871brightlaptophjlpthatswimmingxbwbvolaidhouseancientofbbtdthescreenlaptoplezb",
                "233144546568runningxrpzcriticalbrightdarklpofoundationmelonavmeejforrunningpms",
                "243045536272orangebhfmltmodernchairlightebnitwirelessheavylrfbcomputing,swimmingchairlopu",
                "293854607080jumpingcherrysesdincludinggrapechairjkgrejWi-Fi,brightncqtBluetooth,flyinglaptopnpl",
                "273040445859walkinglightyapandlightmbnymGPS.quicklightezubawalkingrvmniu"
        };

        // TODO: Iterate over encodedData, parse the 3 pairs of indices per element,
        int arrayLength = encodedData.length;
        String sentence = "";
        int w1Start = 0;
        int w1End = 0;
        int w2Start = 0;
        int w2End = 0;
        int w3Start = 0;
        int w3End = 0;

        // straightforward hard codded solution
        for(int i=0;i<arrayLength;i++){
            // For word one, find the start and end, and then extract the word, and add it to our sentence
            w1Start = Integer.parseInt(encodedData[i].substring(0,2));
            w1End = Integer.parseInt(encodedData[i].substring(2,4));
            String word1 = encodedData[i].substring(w1Start,w1End);
            sentence += word1;

            // For word Two, find the start and end, and then extract the word, and add it to our sentence
            w2Start = Integer.parseInt(encodedData[i].substring(4,6));
            w2End = Integer.parseInt(encodedData[i].substring(6,8));
            String word2 = encodedData[i].substring(w2Start,w2End);
            sentence += " " + word2;

            // For word three, find the start and end, and then extract the word, and add it to our sentence
            w3Start = Integer.parseInt(encodedData[i].substring(8,10));
            w3End = Integer.parseInt(encodedData[i].substring(10,12));
            String word3 = encodedData[i].substring(w3Start,w3End);
            sentence += " " + word3 + " ";

        }
        // and extract/print the decoded message!
        System.out.println(sentence);

        // Better Solution
        // We can use StringBuilder instead of String when we are going to make a lot of adjustments to our string.
        StringBuilder sentence2 = new StringBuilder();

        // This way, we are iterating over every item in the encodedData Array
        for (String data : encodedData) {
            // j is from 0 to 12 cause the first 12 items in the string are the start and ends of the words.
            // We move in 4 steps at a time cause each 4 numbers are the start or end of one word.
            for (int j = 0; j < 12; j += 4) {

                // the word start is at j-j+2, and the end is at j+2-j+4.
                int start = Integer.parseInt(data.substring(j, j + 2));
                int end = Integer.parseInt(data.substring(j + 2, j + 4));

                // if the Sentence is not empty, we add a space between words.
                if (!sentence2.isEmpty()) {
                    sentence2.append(" ");
                }
                // add the words to the sentence.
                sentence2.append(data, start, end);
            }
        }

        System.out.println(sentence2.toString());
    }

}