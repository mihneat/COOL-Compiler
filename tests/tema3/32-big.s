    .data
    .align  2
    .globl  class_nameTab
    .globl  Int_protObj
    .globl  String_protObj
    .globl  bool_const0
    .globl  bool_const1
    .globl  Main_protObj
    .globl  _int_tag
    .globl  _string_tag
    .globl  _bool_tag
_int_tag:
    .word   2
_string_tag:
    .word   3
_bool_tag:
    .word   4
str_const0:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const0
    .asciiz ""
    .align  2
str_const1:
    .word   3
    .word   6
    .word   String_dispTab
    .word   int_const6
    .asciiz "Object"
    .align  2
str_const2:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const2
    .asciiz "IO"
    .align  2
str_const3:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const3
    .asciiz "Int"
    .align  2
str_const4:
    .word   3
    .word   6
    .word   String_dispTab
    .word   int_const6
    .asciiz "String"
    .align  2
str_const5:
    .word   3
    .word   6
    .word   String_dispTab
    .word   int_const4
    .asciiz "Bool"
    .align  2
str_const6:
    .word   3
    .word   6
    .word   String_dispTab
    .word   int_const4
    .asciiz "List"
    .align  2
str_const7:
    .word   3
    .word   7
    .word   String_dispTab
    .word   int_const9
    .asciiz "32-big.cl"
    .align  2
str_const8:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz " "
    .align  2
str_const9:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "
"
    .align  2
str_const10:
    .word   3
    .word   6
    .word   String_dispTab
    .word   int_const4
    .asciiz "Main"
    .align  2
str_const11:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "!"
    .align  2
str_const12:
    .word   3
    .word   11
    .word   String_dispTab
    .word   int_const27
    .asciiz "Calculam factorial pentru: "
    .align  2
str_const13:
    .word   3
    .word   10
    .word   String_dispTab
    .word   int_const20
    .asciiz "Factorial recursiv: "
    .align  2
str_const14:
    .word   3
    .word   10
    .word   String_dispTab
    .word   int_const20
    .asciiz "Factorial iterativ: "
    .align  2
str_const15:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const3
    .asciiz "A2I"
    .align  2
str_const16:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "0"
    .align  2
str_const17:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "1"
    .align  2
str_const18:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "2"
    .align  2
str_const19:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "3"
    .align  2
str_const20:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "4"
    .align  2
str_const21:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "5"
    .align  2
str_const22:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "6"
    .align  2
str_const23:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "7"
    .align  2
str_const24:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "8"
    .align  2
str_const25:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "9"
    .align  2
str_const26:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "-"
    .align  2
str_const27:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "+"
    .align  2
int_const0:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   0
int_const1:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   1
int_const2:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   2
int_const3:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   3
int_const4:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   4
int_const5:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   5
int_const6:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   6
int_const9:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   9
int_const27:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   27
int_const20:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   20
int_const7:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   7
int_const8:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   8
int_const10:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   10
bool_const0:
    .word   4
    .word   4
    .word   Bool_dispTab
    .word   0
bool_const1:
    .word   4
    .word   4
    .word   Bool_dispTab
    .word   1

class_nameTab:
    .word   str_const1
    .word   str_const2
    .word   str_const3
    .word   str_const4
    .word   str_const5
    .word   str_const6
    .word   str_const10
    .word   str_const15

class_objTab:
    .word   Object_protObj
    .word   Object_init
    .word   IO_protObj
    .word   IO_init
    .word   Int_protObj
    .word   Int_init
    .word   String_protObj
    .word   String_init
    .word   Bool_protObj
    .word   Bool_init
    .word   List_protObj
    .word   List_init
    .word   Main_protObj
    .word   Main_init
    .word   A2I_protObj
    .word   A2I_init

Object_protObj:
    .word   0
    .word   3
    .word   Object_dispTab
IO_protObj:
    .word   1
    .word   3
    .word   IO_dispTab
Int_protObj:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   0
String_protObj:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const0
    .asciiz ""
    .align  2
Bool_protObj:
    .word   4
    .word   4
    .word   Bool_dispTab
    .word   0
List_protObj:
    .word   5
    .word   5
    .word   List_dispTab
    .word   0
    .word   0
Main_protObj:
    .word   6
    .word   3
    .word   Main_dispTab

A2I_protObj:
    .word   7
    .word   3
    .word   A2I_dispTab


Object_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
IO_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   IO.out_string
    .word   IO.out_int
    .word   IO.in_string
    .word   IO.in_int
Int_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
String_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   String.length
    .word   String.concat
    .word   String.substr
Bool_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
List_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   IO.out_string
    .word   IO.out_int
    .word   IO.in_string
    .word   IO.in_int
    .word   List.init
    .word   List.print
Main_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   IO.out_string
    .word   IO.out_int
    .word   IO.in_string
    .word   IO.in_int
    .word   Main.main
    .word   Main.fact_rec
    .word   Main.fact_iter
A2I_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   A2I.c2i
    .word   A2I.i2c
    .word   A2I.a2i
    .word   A2I.a2i_aux
    .word   A2I.i2a
    .word   A2I.i2a_aux

    .globl  heap_start
heap_start:
    .word 0
    .text
    .globl  Int_init
    .globl  String_init
    .globl  Bool_init
    .globl  Main_init
    .globl  Main.main

Object_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
IO_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
Int_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
String_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
Bool_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
List_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     IO_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
Main_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     IO_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
A2I_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     Object_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra

List.init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -0
    move    $s0 $a0
    lw      $a0 12($fp)
    sw      $a0 12($s0)
    lw      $a0 16($fp)
    sw      $a0 16($s0)
    move    $a0 $s0
    addiu   $sp $sp 0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 8
    jr      $ra
List.print:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -8
    move    $s0 $a0
    lw      $a0 12($s0)
    bnez    $a0 case_0
    la      $a0 str_const7
    li      $t1 24
    jal     _case_abort2
case_0:
    sw      $a0 -8($fp)
    lw      $t1 0($a0)
    blt     $t1 3 caseBranch_0
    bgt     $t1 3 caseBranch_0
    lw      $a0 -8($fp)
    b       endCase_0
caseBranch_0:
    blt     $t1 2 caseBranch_1
    bgt     $t1 2 caseBranch_1
    lw      $a0 -8($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 A2I_protObj
    jal     Object.copy
    jal     A2I_init
    bnez    $a0 dispatch_0                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 26            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_0:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 28($t1)     # Method offset
    jalr    $t1
    b       endCase_0
caseBranch_1:
    blt     $t1 0 caseBranch_2
    bgt     $t1 7 caseBranch_2
    move    $a0 $s0
    bnez    $a0 dispatch_1                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 27            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_1:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 0($t1)     # Method offset
    jalr    $t1
    la      $a0 str_const0
    b       endCase_0
caseBranch_2:
    lw      $a0 -8($fp)
    jal     _case_abort
endCase_0:
    sw      $a0 -4($fp)       # push the result onto the stack
    la      $a0 str_const8
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 -4($fp)
    bnez    $a0 dispatch_2                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 31            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_2:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 16($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_3                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 31            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_3:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 12($t1)     # Method offset
    jalr    $t1
    lw      $a0 16($s0)
    beqz    $a0 isvoid_0
    la      $a0 bool_const0
    b       endIsvoid_0
isvoid_0:
    la      $a0 bool_const1
endIsvoid_0:
    lw      $t1 12($a0)
    beqz    $t1 else_0
    la      $a0 str_const9
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_4                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 32            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_4:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 12($t1)     # Method offset
    jalr    $t1
    b       endIf_0
else_0:
    lw      $a0 16($s0)
    bnez    $a0 dispatch_5                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 32            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_5:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 32($t1)     # Method offset
    jalr    $t1
endIf_0:
    addiu   $sp $sp 8
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 0
    jr      $ra
Main.main:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -24
    move    $s0 $a0
    la      $a0 int_const0
    sw      $a0 -4($fp)       # push the result onto the stack
    la      $a0 str_const11
    sw      $a0 -8($fp)       # push the result onto the stack
    lw      $a0 -4($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const2
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    add     $t1 $t1 $t2
    sw      $t1 12($a0)
    sw      $a0 -12($fp)       # push the result onto the stack
    li      $a0 0
    sw      $a0 -16($fp)       # push the result onto the stack
    lw      $a0 -16($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 -12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 List_protObj
    jal     Object.copy
    jal     List_init
    bnez    $a0 dispatch_6                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 47            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_6:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 28($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 -8($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 List_protObj
    jal     Object.copy
    jal     List_init
    bnez    $a0 dispatch_7                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 46            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_7:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 28($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 -4($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 List_protObj
    jal     Object.copy
    jal     List_init
    bnez    $a0 dispatch_8                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 45            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_8:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 28($t1)     # Method offset
    jalr    $t1
    sw      $a0 -20($fp)       # push the result onto the stack
    lw      $a0 -20($fp)
    bnez    $a0 dispatch_9                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 49            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_9:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 32($t1)     # Method offset
    jalr    $t1

    la      $a0 str_const12
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_10                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 52            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_10:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 12($t1)     # Method offset
    jalr    $t1
    bnez    $a0 dispatch_11                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 52            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_11:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 24($t1)     # Method offset
    jalr    $t1
    sw      $a0 -24($fp)       # push the result onto the stack
    la      $a0 str_const9
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 -24($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_12                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 55            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_12:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 32($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const13
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_13                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 55            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_13:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 12($t1)     # Method offset
    jalr    $t1
    bnez    $a0 dispatch_14                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 55            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_14:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 16($t1)     # Method offset
    jalr    $t1
    bnez    $a0 dispatch_15                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 55            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_15:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 12($t1)     # Method offset
    jalr    $t1
    la      $a0 str_const9
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 -24($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_16                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 57            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_16:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 36($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const14
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_17                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 57            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_17:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 12($t1)     # Method offset
    jalr    $t1
    bnez    $a0 dispatch_18                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 57            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_18:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 16($t1)     # Method offset
    jalr    $t1
    bnez    $a0 dispatch_19                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 57            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_19:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 12($t1)     # Method offset
    jalr    $t1
    addiu   $sp $sp 24
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 0
    jr      $ra
Main.fact_rec:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -0
    move    $s0 $a0
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const0
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_0
    la      $a1 bool_const0
    jal     equality_test
equal_0:
    lw      $t1 12($a0)
    beqz    $t1 else_1
    la      $a0 int_const1
    b       endIf_1
else_1:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const1
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    sub     $t1 $t1 $t2
    sw      $t1 12($a0)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_20                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 65            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_20:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 32($t1)     # Method offset
    jalr    $t1
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    mul     $t1 $t1 $t2
    sw      $t1 12($a0)
endIf_1:
    addiu   $sp $sp 0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra
Main.fact_iter:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -4
    move    $s0 $a0
    la      $a0 int_const1
    sw      $a0 -4($fp)       # push the result onto the stack
loopStart_0:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const0
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_1
    la      $a1 bool_const0
    jal     equality_test
equal_1:
    lw      $t1 12($a0)
    la      $a0 bool_const1
    beqz    $t1 not_0
    la      $a0 bool_const0
not_0:
    lw      $t1 12($a0)
    beqz    $t1 whileEnd_0
    lw      $a0 -4($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 12($fp)
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    mul     $t1 $t1 $t2
    sw      $t1 12($a0)
    sw      $a0 -4($fp)
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const1
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    sub     $t1 $t1 $t2
    sw      $t1 12($a0)
    sw      $a0 12($fp)
    b       loopStart_0
whileEnd_0:
    li      $a0 0
    lw      $a0 -4($fp)
    addiu   $sp $sp 4
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra
A2I.c2i:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -0
    move    $s0 $a0
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const16
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_2
    la      $a1 bool_const0
    jal     equality_test
equal_2:
    lw      $t1 12($a0)
    beqz    $t1 else_11
    la      $a0 int_const0
    b       endIf_11
else_11:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const17
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_3
    la      $a1 bool_const0
    jal     equality_test
equal_3:
    lw      $t1 12($a0)
    beqz    $t1 else_10
    la      $a0 int_const1
    b       endIf_10
else_10:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const18
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_4
    la      $a1 bool_const0
    jal     equality_test
equal_4:
    lw      $t1 12($a0)
    beqz    $t1 else_9
    la      $a0 int_const2
    b       endIf_9
else_9:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const19
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_5
    la      $a1 bool_const0
    jal     equality_test
equal_5:
    lw      $t1 12($a0)
    beqz    $t1 else_8
    la      $a0 int_const3
    b       endIf_8
else_8:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const20
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_6
    la      $a1 bool_const0
    jal     equality_test
equal_6:
    lw      $t1 12($a0)
    beqz    $t1 else_7
    la      $a0 int_const4
    b       endIf_7
else_7:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const21
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_7
    la      $a1 bool_const0
    jal     equality_test
equal_7:
    lw      $t1 12($a0)
    beqz    $t1 else_6
    la      $a0 int_const5
    b       endIf_6
else_6:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const22
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_8
    la      $a1 bool_const0
    jal     equality_test
equal_8:
    lw      $t1 12($a0)
    beqz    $t1 else_5
    la      $a0 int_const6
    b       endIf_5
else_5:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const23
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_9
    la      $a1 bool_const0
    jal     equality_test
equal_9:
    lw      $t1 12($a0)
    beqz    $t1 else_4
    la      $a0 int_const7
    b       endIf_4
else_4:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const24
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_10
    la      $a1 bool_const0
    jal     equality_test
equal_10:
    lw      $t1 12($a0)
    beqz    $t1 else_3
    la      $a0 int_const8
    b       endIf_3
else_3:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const25
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_11
    la      $a1 bool_const0
    jal     equality_test
equal_11:
    lw      $t1 12($a0)
    beqz    $t1 else_2
    la      $a0 int_const9
    b       endIf_2
else_2:
    move    $a0 $s0
    bnez    $a0 dispatch_21                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 111            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_21:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 0($t1)     # Method offset
    jalr    $t1
    la      $a0 int_const0
endIf_2:
endIf_3:
endIf_4:
endIf_5:
endIf_6:
endIf_7:
endIf_8:
endIf_9:
endIf_10:
endIf_11:
    addiu   $sp $sp 0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra
A2I.i2c:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -0
    move    $s0 $a0
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const0
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_12
    la      $a1 bool_const0
    jal     equality_test
equal_12:
    lw      $t1 12($a0)
    beqz    $t1 else_21
    la      $a0 str_const16
    b       endIf_21
else_21:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const1
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_13
    la      $a1 bool_const0
    jal     equality_test
equal_13:
    lw      $t1 12($a0)
    beqz    $t1 else_20
    la      $a0 str_const17
    b       endIf_20
else_20:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const2
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_14
    la      $a1 bool_const0
    jal     equality_test
equal_14:
    lw      $t1 12($a0)
    beqz    $t1 else_19
    la      $a0 str_const18
    b       endIf_19
else_19:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const3
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_15
    la      $a1 bool_const0
    jal     equality_test
equal_15:
    lw      $t1 12($a0)
    beqz    $t1 else_18
    la      $a0 str_const19
    b       endIf_18
else_18:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const4
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_16
    la      $a1 bool_const0
    jal     equality_test
equal_16:
    lw      $t1 12($a0)
    beqz    $t1 else_17
    la      $a0 str_const20
    b       endIf_17
else_17:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const5
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_17
    la      $a1 bool_const0
    jal     equality_test
equal_17:
    lw      $t1 12($a0)
    beqz    $t1 else_16
    la      $a0 str_const21
    b       endIf_16
else_16:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const6
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_18
    la      $a1 bool_const0
    jal     equality_test
equal_18:
    lw      $t1 12($a0)
    beqz    $t1 else_15
    la      $a0 str_const22
    b       endIf_15
else_15:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const7
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_19
    la      $a1 bool_const0
    jal     equality_test
equal_19:
    lw      $t1 12($a0)
    beqz    $t1 else_14
    la      $a0 str_const23
    b       endIf_14
else_14:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const8
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_20
    la      $a1 bool_const0
    jal     equality_test
equal_20:
    lw      $t1 12($a0)
    beqz    $t1 else_13
    la      $a0 str_const24
    b       endIf_13
else_13:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const9
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_21
    la      $a1 bool_const0
    jal     equality_test
equal_21:
    lw      $t1 12($a0)
    beqz    $t1 else_12
    la      $a0 str_const25
    b       endIf_12
else_12:
    move    $a0 $s0
    bnez    $a0 dispatch_22                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 129            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_22:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 0($t1)     # Method offset
    jalr    $t1
    la      $a0 str_const0
endIf_12:
endIf_13:
endIf_14:
endIf_15:
endIf_16:
endIf_17:
endIf_18:
endIf_19:
endIf_20:
endIf_21:
    addiu   $sp $sp 0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra
A2I.a2i:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -0
    move    $s0 $a0
    lw      $a0 12($fp)
    bnez    $a0 dispatch_24                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 142            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_24:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 12($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const0
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_22
    la      $a1 bool_const0
    jal     equality_test
equal_22:
    lw      $t1 12($a0)
    beqz    $t1 else_24
    la      $a0 int_const0
    b       endIf_24
else_24:
    la      $a0 int_const1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const0
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 12($fp)
    bnez    $a0 dispatch_26                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 143            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_26:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 20($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const26
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_23
    la      $a1 bool_const0
    jal     equality_test
equal_23:
    lw      $t1 12($a0)
    beqz    $t1 else_23
    lw      $a0 12($fp)
    bnez    $a0 dispatch_27                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 143            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_27:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 12($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const1
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    sub     $t1 $t1 $t2
    sw      $t1 12($a0)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 12($fp)
    bnez    $a0 dispatch_28                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 143            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_28:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 20($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_29                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 143            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_29:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 24($t1)     # Method offset
    jalr    $t1
    jal     Object.copy
    lw      $t1 12($a0)
    neg     $t1 $t1
    sw      $t1 12($a0)
    b       endIf_23
else_23:
    la      $a0 int_const1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const0
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 12($fp)
    bnez    $a0 dispatch_31                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 144            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_31:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 20($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const27
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_24
    la      $a1 bool_const0
    jal     equality_test
equal_24:
    lw      $t1 12($a0)
    beqz    $t1 else_22
    lw      $a0 12($fp)
    bnez    $a0 dispatch_32                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 144            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_32:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 12($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const1
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    sub     $t1 $t1 $t2
    sw      $t1 12($a0)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 12($fp)
    bnez    $a0 dispatch_33                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 144            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_33:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 20($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_34                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 144            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_34:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 24($t1)     # Method offset
    jalr    $t1
    b       endIf_22
else_22:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_35                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 145            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_35:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 24($t1)     # Method offset
    jalr    $t1
endIf_22:
endIf_23:
endIf_24:
    addiu   $sp $sp 0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra
A2I.a2i_aux:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -12
    move    $s0 $a0
    la      $a0 int_const0
    sw      $a0 -4($fp)       # push the result onto the stack
    lw      $a0 12($fp)
    bnez    $a0 dispatch_36                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 156            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_36:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 12($t1)     # Method offset
    jalr    $t1
    sw      $a0 -8($fp)       # push the result onto the stack
    la      $a0 int_const0
    sw      $a0 -12($fp)       # push the result onto the stack
loopStart_1:
    lw      $a0 -12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 -8($fp)
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    la      $a0 bool_const1
    blt    $t1 $t2 compare_0
    la      $a0 bool_const0
compare_0:
    lw      $t1 12($a0)
    beqz    $t1 whileEnd_1
    lw      $a0 -4($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const10
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    mul     $t1 $t1 $t2
    sw      $t1 12($a0)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 -12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 12($fp)
    bnez    $a0 dispatch_37                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 160            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_37:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 20($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_38                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 160            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_38:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 12($t1)     # Method offset
    jalr    $t1
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    add     $t1 $t1 $t2
    sw      $t1 12($a0)
    sw      $a0 -4($fp)
    lw      $a0 -12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const1
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    add     $t1 $t1 $t2
    sw      $t1 12($a0)
    sw      $a0 -12($fp)
    b       loopStart_1
whileEnd_1:
    li      $a0 0
    lw      $a0 -4($fp)
    addiu   $sp $sp 12
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra
A2I.i2a:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -0
    move    $s0 $a0
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const0
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_25
    la      $a1 bool_const0
    jal     equality_test
equal_25:
    lw      $t1 12($a0)
    beqz    $t1 else_26
    la      $a0 str_const16
    b       endIf_26
else_26:
    la      $a0 int_const0
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 12($fp)
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    la      $a0 bool_const1
    blt    $t1 $t2 compare_1
    la      $a0 bool_const0
compare_1:
    lw      $t1 12($a0)
    beqz    $t1 else_25
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_39                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 177            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_39:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 32($t1)     # Method offset
    jalr    $t1
    b       endIf_25
else_25:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const1
    jal     Object.copy
    lw      $t1 12($a0)
    neg     $t1 $t1
    sw      $t1 12($a0)
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    mul     $t1 $t1 $t2
    sw      $t1 12($a0)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_40                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 178            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_40:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 32($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const26
    bnez    $a0 dispatch_41                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 178            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_41:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 16($t1)     # Method offset
    jalr    $t1
endIf_25:
endIf_26:
    addiu   $sp $sp 0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra
A2I.i2a_aux:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -4
    move    $s0 $a0
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const0
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    move    $t2 $a0
    la      $a0 bool_const1
    beq     $t1 $t2 equal_26
    la      $a1 bool_const0
    jal     equality_test
equal_26:
    lw      $t1 12($a0)
    beqz    $t1 else_27
    la      $a0 str_const0
    b       endIf_27
else_27:
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const10
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    div     $t1 $t1 $t2
    sw      $t1 12($a0)
    sw      $a0 -4($fp)       # push the result onto the stack
    lw      $a0 12($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 -4($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 int_const10
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    mul     $t1 $t1 $t2
    sw      $t1 12($a0)
    jal     Object.copy
    lw      $t1 4($sp)
    addiu   $sp $sp 4
    lw      $t1 12($t1)
    lw      $t2 12($a0)
    sub     $t1 $t1 $t2
    sw      $t1 12($a0)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_42                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 188            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_42:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 16($t1)     # Method offset
    jalr    $t1
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    lw      $a0 -4($fp)
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_43                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 188            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_43:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 32($t1)     # Method offset
    jalr    $t1
    bnez    $a0 dispatch_44                 # Check for 'void'
    la      $a0 str_const7  # Store the file name in $a0
    li      $t1 188            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_44:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 16($t1)     # Method offset
    jalr    $t1
endIf_27:
    addiu   $sp $sp 4
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 4
    jr      $ra
