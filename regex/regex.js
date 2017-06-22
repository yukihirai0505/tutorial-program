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

// part4

// {} => repeat num for before character
// 0{2} => 00
// @{2,} => 00,000,00000
// @{2,4} => 00, 000, 0000

// [a-z]{5}
// [a-z]{3,5}

// part5

// a? => 0 or 1 =>  , a
// a* => 0 or more => , a, aaaa, aaaaaa
// a+ => 1 or more => a, aaa, aaaaaa

// part6

// () => (abc)* => abc, abcabc
// |  => or => (abc|def) => abc, def

// part7

// \n => break line
// \t => tab
// \d => number [0-9]
// \w => english number _ [A-Za-z0-9_]
// \s => space or tab
// \(meta caharacter) => meta => \/

// part8

// javascript options

// i => uppercase and lowercase
// g => return all match element
// m => apply multi line