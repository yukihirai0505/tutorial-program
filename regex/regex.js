// practice /regexp?/

// part1

var s = '@taguchi, @fkoji, @dotinstall';
var rs = s.match(/taguchi/);

if (rs) {
  console.log('マッチしました!')
}

// part2

// meta character

// [abc] => a or b or c
// [a-c] => a to c
// [^abc] => not a or not b or not c

var s = '@teguchi, @fkoji, @dotinstall';
var rs = s.match(/t[^ao]guchi/);

if (rs) {
  console.log('マッチしました!')
}

// part3

// . => any one word
// ^ => beginning of line * if you use ^ inside [] it means not ~
// $ => end of line

var s = '@teguchi, @fkoji, @dotinstall';
var rs = s.match(/^@t.guchi.*l$/);

if (rs) {
  console.log('マッチしました!')
}