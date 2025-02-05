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
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "A"
    .align  2
str_const7:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "B"
    .align  2
str_const8:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const3
    .asciiz "abc"
    .align  2
str_const9:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "C"
    .align  2
str_const10:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "D"
    .align  2
str_const11:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "E"
    .align  2
str_const12:
    .word   3
    .word   5
    .word   String_dispTab
    .word   int_const1
    .asciiz "F"
    .align  2
str_const13:
    .word   3
    .word   6
    .word   String_dispTab
    .word   int_const4
    .asciiz "Main"
    .align  2
str_const14:
    .word   3
    .word   10
    .word   String_dispTab
    .word   int_const23
    .asciiz "09-dispatch-chain-IO.cl"
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
int_const100:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   100
int_const23:
    .word   2
    .word   4
    .word   Int_dispTab
    .word   23
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
    .word   str_const7
    .word   str_const9
    .word   str_const10
    .word   str_const11
    .word   str_const12
    .word   str_const13

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
    .word   A_protObj
    .word   A_init
    .word   B_protObj
    .word   B_init
    .word   C_protObj
    .word   C_init
    .word   D_protObj
    .word   D_init
    .word   E_protObj
    .word   E_init
    .word   F_protObj
    .word   F_init
    .word   Main_protObj
    .word   Main_init

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
A_protObj:
    .word   5
    .word   4
    .word   A_dispTab
    .word   int_const0
B_protObj:
    .word   6
    .word   5
    .word   B_dispTab
    .word   int_const0
    .word   str_const0
C_protObj:
    .word   7
    .word   5
    .word   C_dispTab
    .word   int_const0
    .word   bool_const0
D_protObj:
    .word   8
    .word   5
    .word   D_dispTab
    .word   int_const0
    .word   str_const0
E_protObj:
    .word   9
    .word   5
    .word   E_dispTab
    .word   int_const0
    .word   str_const0
F_protObj:
    .word   10
    .word   5
    .word   F_dispTab
    .word   int_const0
    .word   bool_const0
Main_protObj:
    .word   11
    .word   6
    .word   Main_dispTab
    .word   int_const0
    .word   str_const0
    .word   0

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
A_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   IO.out_string
    .word   IO.out_int
    .word   IO.in_string
    .word   IO.in_int
    .word   A.f
B_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   IO.out_string
    .word   IO.out_int
    .word   IO.in_string
    .word   IO.in_int
    .word   A.f
    .word   B.g
C_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   IO.out_string
    .word   IO.out_int
    .word   IO.in_string
    .word   IO.in_int
    .word   C.f
    .word   C.h
D_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   IO.out_string
    .word   IO.out_int
    .word   IO.in_string
    .word   IO.in_int
    .word   A.f
    .word   B.g
E_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   IO.out_string
    .word   IO.out_int
    .word   IO.in_string
    .word   IO.in_int
    .word   A.f
    .word   B.g
F_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   IO.out_string
    .word   IO.out_int
    .word   IO.in_string
    .word   IO.in_int
    .word   C.f
    .word   C.h
Main_dispTab:
    .word   Object.abort
    .word   Object.type_name
    .word   Object.copy
    .word   IO.out_string
    .word   IO.out_int
    .word   IO.in_string
    .word   IO.in_int
    .word   A.f
    .word   B.g
    .word   Main.main

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
A_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     IO_init
    la      $a0 int_const100
    sw      $a0 12($s0)
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
B_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     A_init
    la      $a0 str_const8
    sw      $a0 16($s0)
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
C_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     A_init
    la      $a0 bool_const1
    sw      $a0 16($s0)
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
D_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     B_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
E_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     B_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra
F_init:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    move    $s0 $a0
    jal     C_init
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
    jal     E_init
    move    $a0 $s0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    jr      $ra

A.f:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -0
    move    $s0 $a0
    la      $a0 int_const1
    addiu   $sp $sp 0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 0
    jr      $ra
B.g:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -0
    move    $s0 $a0
    la      $a0 int_const2
    addiu   $sp $sp 0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 0
    jr      $ra
C.f:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -0
    move    $s0 $a0
    la      $a0 int_const3
    addiu   $sp $sp 0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 0
    jr      $ra
C.h:
    addiu   $sp $sp -12
    sw      $fp 12($sp)
    sw      $s0 8($sp)
    sw      $ra 4($sp)
    addiu   $fp $sp 4
    addiu   $sp $sp -0
    move    $s0 $a0
    la      $a0 int_const4
    addiu   $sp $sp 0
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
    addiu   $sp $sp -0
    move    $s0 $a0
    la      $a0 int_const100
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    la      $a0 str_const8
    sw      $a0 0($sp)
    addiu   $sp $sp -4
    move    $a0 $s0
    bnez    $a0 dispatch_0                 # Check for 'void'
    la      $a0 str_const14  # Store the file name in $a0
    li      $t1 30            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_0:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 12($t1)     # Method offset
    jalr    $t1
    bnez    $a0 dispatch_1                 # Check for 'void'
    la      $a0 str_const14  # Store the file name in $a0
    li      $t1 30            # Store the line number
    jal     _dispatch_abort             # Abort
dispatch_1:
    lw      $t1 8($a0)          # Dispatch table
    lw      $t1 16($t1)     # Method offset
    jalr    $t1
    addiu   $sp $sp 0
    lw      $fp 12($sp)
    lw      $s0 8($sp)
    lw      $ra 4($sp)
    addiu   $sp $sp 12
    addiu   $sp $sp 0
    jr      $ra
