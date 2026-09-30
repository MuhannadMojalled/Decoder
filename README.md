Problem Description:

You are given an array of encoded text blocks. Each block contains a message obscured by random dictionary decoy words, noise characters, and a positional coordinate header at the very start.
Without the header coordinates, searching through all the random decoy words would make the text impossible to decipher manually.

```
   HEADER     BODY (Decoy Words + Target Words + Noise)

/----------\/----------------------------------------\

262838404748fhhfgoncepyfghthefdgandetscatgrshjcisow;cn
```

| Target    | Start Index Range | End Index Range | Meaning |
| -------- | ------- | -------- | ------- | 
| Word 1 | Digits at 0..1    | Digits at 2..3 | Start & end position of 1st word |
| Word 2 | Digits at 4..5   | Digits at 6..7 | Start & end position of 2nd word |
| Word 3 | Digits at 8..9   | Digits at 10..11 | Start & end position of 3rd word |

Header Format Rules

The first 12 digits (indices 0 through 11) of each String encode 3 pairs of 2-digit index numbers:

Example Breakdown
For the string element:"262838404748fhhfgoncepyfghthefdgandetscatgrshjcisow;cn"

Header Breakdown:

Digits 0..3 >>> "2628" >>> Extract substring from index 26 to 28 >>> "the"

Digits 4..7 >>> "3840" >>> Extract substring from index 38 to 40 >>> "cat"

Digits 8..11 >>> "4748" >>> Extract substring from index 47 to 48 >>> "is"

By iterating through the array and stitching together only the coordinate-targeted substrings, you will reveal the secret phrase!

Starter Code

Open the Decoder.java file from your forked repository
