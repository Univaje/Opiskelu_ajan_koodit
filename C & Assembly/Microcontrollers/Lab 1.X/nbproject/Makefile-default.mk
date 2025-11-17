#
# Generated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Include project Makefile
ifeq "${IGNORE_LOCAL}" "TRUE"
# do not include local makefile. User is passing all local related variables already
else
include Makefile
# Include makefile containing local settings
ifeq "$(wildcard nbproject/Makefile-local-default.mk)" "nbproject/Makefile-local-default.mk"
include nbproject/Makefile-local-default.mk
endif
endif

# Environment
MKDIR=gnumkdir -p
RM=rm -f 
MV=mv 
CP=cp 

# Macros
CND_CONF=default
ifeq ($(TYPE_IMAGE), DEBUG_RUN)
IMAGE_TYPE=debug
OUTPUT_SUFFIX=cof
DEBUGGABLE_SUFFIX=cof
FINAL_IMAGE=dist/${CND_CONF}/${IMAGE_TYPE}/Lab_1.X.${IMAGE_TYPE}.${OUTPUT_SUFFIX}
else
IMAGE_TYPE=production
OUTPUT_SUFFIX=hex
DEBUGGABLE_SUFFIX=cof
FINAL_IMAGE=dist/${CND_CONF}/${IMAGE_TYPE}/Lab_1.X.${IMAGE_TYPE}.${OUTPUT_SUFFIX}
endif

ifeq ($(COMPARE_BUILD), true)
COMPARISON_BUILD=
else
COMPARISON_BUILD=
endif

ifdef SUB_IMAGE_ADDRESS

else
SUB_IMAGE_ADDRESS_COMMAND=
endif

# Object Directory
OBJECTDIR=build/${CND_CONF}/${IMAGE_TYPE}

# Distribution Directory
DISTDIR=dist/${CND_CONF}/${IMAGE_TYPE}

# Source Files Quoted if spaced
SOURCEFILES_QUOTED_IF_SPACED=Lab1_LED.asm "Vähennä 2 16bit numeroa.asm" "plussaa 2 16bittistä lukua.asm" "kerrotaan 16bit numero 8bit numerolla.asm" "Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.asm" "kierrätä bitit.asm" "BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.asm" "kaksi microcontrolleria yhdistetty portB0.asm" "XOR of bits.asm" "Exam questions.asm" "timer- tee 50 duty cycle porttiinB5.asm" "timer - wave square wave 10ms period pinniin PORTB%.asm" "Timer calculate delay.asm" "Timer - generate pulse with freguency 1devided160.asm" "Timer program to measure RPS of wheel send to PortD.asm" "Prescaler and postscaler.asm" "Interrupt generate square wave on rb3.asm" 5.10.asm "tentti kysymykset.asm" Interrupt.asm ADC.asm "ADC with interrupt.asm" Dac.asm "C language Timer.asm" "Assigment 3.asm" "C programming.asm" Lab3_Timer.asm newAsmTemplate.asm

# Object Files Quoted if spaced
OBJECTFILES_QUOTED_IF_SPACED=${OBJECTDIR}/Lab1_LED.o "${OBJECTDIR}/Vähennä 2 16bit numeroa.o" "${OBJECTDIR}/plussaa 2 16bittistä lukua.o" "${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.o" "${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.o" "${OBJECTDIR}/kierrätä bitit.o" "${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.o" "${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.o" "${OBJECTDIR}/XOR of bits.o" "${OBJECTDIR}/Exam questions.o" "${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.o" "${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.o" "${OBJECTDIR}/Timer calculate delay.o" "${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.o" "${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.o" "${OBJECTDIR}/Prescaler and postscaler.o" "${OBJECTDIR}/Interrupt generate square wave on rb3.o" ${OBJECTDIR}/5.10.o "${OBJECTDIR}/tentti kysymykset.o" ${OBJECTDIR}/Interrupt.o ${OBJECTDIR}/ADC.o "${OBJECTDIR}/ADC with interrupt.o" ${OBJECTDIR}/Dac.o "${OBJECTDIR}/C language Timer.o" "${OBJECTDIR}/Assigment 3.o" "${OBJECTDIR}/C programming.o" ${OBJECTDIR}/Lab3_Timer.o ${OBJECTDIR}/newAsmTemplate.o
POSSIBLE_DEPFILES=${OBJECTDIR}/Lab1_LED.o.d "${OBJECTDIR}/Vähennä 2 16bit numeroa.o.d" "${OBJECTDIR}/plussaa 2 16bittistä lukua.o.d" "${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.o.d" "${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.o.d" "${OBJECTDIR}/kierrätä bitit.o.d" "${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.o.d" "${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.o.d" "${OBJECTDIR}/XOR of bits.o.d" "${OBJECTDIR}/Exam questions.o.d" "${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.o.d" "${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.o.d" "${OBJECTDIR}/Timer calculate delay.o.d" "${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.o.d" "${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.o.d" "${OBJECTDIR}/Prescaler and postscaler.o.d" "${OBJECTDIR}/Interrupt generate square wave on rb3.o.d" ${OBJECTDIR}/5.10.o.d "${OBJECTDIR}/tentti kysymykset.o.d" ${OBJECTDIR}/Interrupt.o.d ${OBJECTDIR}/ADC.o.d "${OBJECTDIR}/ADC with interrupt.o.d" ${OBJECTDIR}/Dac.o.d "${OBJECTDIR}/C language Timer.o.d" "${OBJECTDIR}/Assigment 3.o.d" "${OBJECTDIR}/C programming.o.d" ${OBJECTDIR}/Lab3_Timer.o.d ${OBJECTDIR}/newAsmTemplate.o.d

# Object Files
OBJECTFILES=${OBJECTDIR}/Lab1_LED.o ${OBJECTDIR}/Vähennä\ 2\ 16bit\ numeroa.o ${OBJECTDIR}/plussaa\ 2\ 16bittistä\ lukua.o ${OBJECTDIR}/kerrotaan\ 16bit\ numero\ 8bit\ numerolla.o ${OBJECTDIR}/Kerro\ 2\ 8bit\ numeroa.\ oleta\ että\ numerot\ ovat\ 2complementissa.o ${OBJECTDIR}/kierrätä\ bitit.o ${OBJECTDIR}/BCDbyte\ kahteen\ rekisteriin\ ja\ lähetä\ ne\ porttia\ ja\ b.o ${OBJECTDIR}/kaksi\ microcontrolleria\ yhdistetty\ portB0.o ${OBJECTDIR}/XOR\ of\ bits.o ${OBJECTDIR}/Exam\ questions.o ${OBJECTDIR}/timer-\ tee\ 50\ duty\ cycle\ porttiinB5.o ${OBJECTDIR}/timer\ -\ wave\ square\ wave\ 10ms\ period\ pinniin\ PORTB%.o ${OBJECTDIR}/Timer\ calculate\ delay.o ${OBJECTDIR}/Timer\ -\ generate\ pulse\ with\ freguency\ 1devided160.o ${OBJECTDIR}/Timer\ program\ to\ measure\ RPS\ of\ wheel\ send\ to\ PortD.o ${OBJECTDIR}/Prescaler\ and\ postscaler.o ${OBJECTDIR}/Interrupt\ generate\ square\ wave\ on\ rb3.o ${OBJECTDIR}/5.10.o ${OBJECTDIR}/tentti\ kysymykset.o ${OBJECTDIR}/Interrupt.o ${OBJECTDIR}/ADC.o ${OBJECTDIR}/ADC\ with\ interrupt.o ${OBJECTDIR}/Dac.o ${OBJECTDIR}/C\ language\ Timer.o ${OBJECTDIR}/Assigment\ 3.o ${OBJECTDIR}/C\ programming.o ${OBJECTDIR}/Lab3_Timer.o ${OBJECTDIR}/newAsmTemplate.o

# Source Files
SOURCEFILES=Lab1_LED.asm Vähennä 2 16bit numeroa.asm plussaa 2 16bittistä lukua.asm kerrotaan 16bit numero 8bit numerolla.asm Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.asm kierrätä bitit.asm BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.asm kaksi microcontrolleria yhdistetty portB0.asm XOR of bits.asm Exam questions.asm timer- tee 50 duty cycle porttiinB5.asm timer - wave square wave 10ms period pinniin PORTB%.asm Timer calculate delay.asm Timer - generate pulse with freguency 1devided160.asm Timer program to measure RPS of wheel send to PortD.asm Prescaler and postscaler.asm Interrupt generate square wave on rb3.asm 5.10.asm tentti kysymykset.asm Interrupt.asm ADC.asm ADC with interrupt.asm Dac.asm C language Timer.asm Assigment 3.asm C programming.asm Lab3_Timer.asm newAsmTemplate.asm


CFLAGS=
ASFLAGS=
LDLIBSOPTIONS=

############# Tool locations ##########################################
# If you copy a project from one host to another, the path where the  #
# compiler is installed may be different.                             #
# If you open this project with MPLAB X in the new host, this         #
# makefile will be regenerated and the paths will be corrected.       #
#######################################################################
# fixDeps replaces a bunch of sed/cat/printf statements that slow down the build
FIXDEPS=fixDeps

.build-conf:  ${BUILD_SUBPROJECTS}
ifneq ($(INFORMATION_MESSAGE), )
	@echo $(INFORMATION_MESSAGE)
endif
	${MAKE}  -f nbproject/Makefile-default.mk dist/${CND_CONF}/${IMAGE_TYPE}/Lab_1.X.${IMAGE_TYPE}.${OUTPUT_SUFFIX}

MP_PROCESSOR_OPTION=18f87j11
MP_LINKER_DEBUG_OPTION= 
# ------------------------------------------------------------------------------------
# Rules for buildStep: assemble
ifeq ($(TYPE_IMAGE), DEBUG_RUN)
${OBJECTDIR}/Lab1_LED.o: Lab1_LED.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/Lab1_LED.o.d 
	@${RM} ${OBJECTDIR}/Lab1_LED.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Lab1_LED.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Lab1_LED.lst\" -e\"${OBJECTDIR}/Lab1_LED.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Lab1_LED.o\" \"Lab1_LED.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Lab1_LED.o"
	@${FIXDEPS} "${OBJECTDIR}/Lab1_LED.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Vähennä\ 2\ 16bit\ numeroa.o: Vähennä\ 2\ 16bit\ numeroa.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Vähennä 2 16bit numeroa.o".d 
	@${RM} "${OBJECTDIR}/Vähennä 2 16bit numeroa.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Vähennä 2 16bit numeroa.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Vähennä 2 16bit numeroa.lst\" -e\"${OBJECTDIR}/Vähennä 2 16bit numeroa.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Vähennä 2 16bit numeroa.o\" \"Vähennä 2 16bit numeroa.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Vähennä 2 16bit numeroa.o"
	@${FIXDEPS} "${OBJECTDIR}/Vähennä 2 16bit numeroa.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/plussaa\ 2\ 16bittistä\ lukua.o: plussaa\ 2\ 16bittistä\ lukua.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/plussaa 2 16bittistä lukua.o".d 
	@${RM} "${OBJECTDIR}/plussaa 2 16bittistä lukua.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/plussaa 2 16bittistä lukua.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/plussaa 2 16bittistä lukua.lst\" -e\"${OBJECTDIR}/plussaa 2 16bittistä lukua.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/plussaa 2 16bittistä lukua.o\" \"plussaa 2 16bittistä lukua.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/plussaa 2 16bittistä lukua.o"
	@${FIXDEPS} "${OBJECTDIR}/plussaa 2 16bittistä lukua.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/kerrotaan\ 16bit\ numero\ 8bit\ numerolla.o: kerrotaan\ 16bit\ numero\ 8bit\ numerolla.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.o".d 
	@${RM} "${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.lst\" -e\"${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.o\" \"kerrotaan 16bit numero 8bit numerolla.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.o"
	@${FIXDEPS} "${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Kerro\ 2\ 8bit\ numeroa.\ oleta\ että\ numerot\ ovat\ 2complementissa.o: Kerro\ 2\ 8bit\ numeroa.\ oleta\ että\ numerot\ ovat\ 2complementissa.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.o".d 
	@${RM} "${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.lst\" -e\"${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.o\" \"Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.o"
	@${FIXDEPS} "${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/kierrätä\ bitit.o: kierrätä\ bitit.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/kierrätä bitit.o".d 
	@${RM} "${OBJECTDIR}/kierrätä bitit.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/kierrätä bitit.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/kierrätä bitit.lst\" -e\"${OBJECTDIR}/kierrätä bitit.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/kierrätä bitit.o\" \"kierrätä bitit.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/kierrätä bitit.o"
	@${FIXDEPS} "${OBJECTDIR}/kierrätä bitit.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/BCDbyte\ kahteen\ rekisteriin\ ja\ lähetä\ ne\ porttia\ ja\ b.o: BCDbyte\ kahteen\ rekisteriin\ ja\ lähetä\ ne\ porttia\ ja\ b.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.o".d 
	@${RM} "${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.lst\" -e\"${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.o\" \"BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.o"
	@${FIXDEPS} "${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/kaksi\ microcontrolleria\ yhdistetty\ portB0.o: kaksi\ microcontrolleria\ yhdistetty\ portB0.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.o".d 
	@${RM} "${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.lst\" -e\"${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.o\" \"kaksi microcontrolleria yhdistetty portB0.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.o"
	@${FIXDEPS} "${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/XOR\ of\ bits.o: XOR\ of\ bits.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/XOR of bits.o".d 
	@${RM} "${OBJECTDIR}/XOR of bits.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/XOR of bits.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/XOR of bits.lst\" -e\"${OBJECTDIR}/XOR of bits.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/XOR of bits.o\" \"XOR of bits.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/XOR of bits.o"
	@${FIXDEPS} "${OBJECTDIR}/XOR of bits.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Exam\ questions.o: Exam\ questions.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Exam questions.o".d 
	@${RM} "${OBJECTDIR}/Exam questions.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Exam questions.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Exam questions.lst\" -e\"${OBJECTDIR}/Exam questions.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Exam questions.o\" \"Exam questions.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Exam questions.o"
	@${FIXDEPS} "${OBJECTDIR}/Exam questions.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/timer-\ tee\ 50\ duty\ cycle\ porttiinB5.o: timer-\ tee\ 50\ duty\ cycle\ porttiinB5.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.o".d 
	@${RM} "${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.lst\" -e\"${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.o\" \"timer- tee 50 duty cycle porttiinB5.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.o"
	@${FIXDEPS} "${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/timer\ -\ wave\ square\ wave\ 10ms\ period\ pinniin\ PORTB%.o: timer\ -\ wave\ square\ wave\ 10ms\ period\ pinniin\ PORTB%.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.o".d 
	@${RM} "${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.lst\" -e\"${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.o\" \"timer - wave square wave 10ms period pinniin PORTB%.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.o"
	@${FIXDEPS} "${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Timer\ calculate\ delay.o: Timer\ calculate\ delay.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Timer calculate delay.o".d 
	@${RM} "${OBJECTDIR}/Timer calculate delay.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Timer calculate delay.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Timer calculate delay.lst\" -e\"${OBJECTDIR}/Timer calculate delay.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Timer calculate delay.o\" \"Timer calculate delay.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Timer calculate delay.o"
	@${FIXDEPS} "${OBJECTDIR}/Timer calculate delay.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Timer\ -\ generate\ pulse\ with\ freguency\ 1devided160.o: Timer\ -\ generate\ pulse\ with\ freguency\ 1devided160.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.o".d 
	@${RM} "${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.lst\" -e\"${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.o\" \"Timer - generate pulse with freguency 1devided160.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.o"
	@${FIXDEPS} "${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Timer\ program\ to\ measure\ RPS\ of\ wheel\ send\ to\ PortD.o: Timer\ program\ to\ measure\ RPS\ of\ wheel\ send\ to\ PortD.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.o".d 
	@${RM} "${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.lst\" -e\"${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.o\" \"Timer program to measure RPS of wheel send to PortD.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.o"
	@${FIXDEPS} "${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Prescaler\ and\ postscaler.o: Prescaler\ and\ postscaler.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Prescaler and postscaler.o".d 
	@${RM} "${OBJECTDIR}/Prescaler and postscaler.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Prescaler and postscaler.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Prescaler and postscaler.lst\" -e\"${OBJECTDIR}/Prescaler and postscaler.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Prescaler and postscaler.o\" \"Prescaler and postscaler.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Prescaler and postscaler.o"
	@${FIXDEPS} "${OBJECTDIR}/Prescaler and postscaler.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Interrupt\ generate\ square\ wave\ on\ rb3.o: Interrupt\ generate\ square\ wave\ on\ rb3.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Interrupt generate square wave on rb3.o".d 
	@${RM} "${OBJECTDIR}/Interrupt generate square wave on rb3.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Interrupt generate square wave on rb3.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Interrupt generate square wave on rb3.lst\" -e\"${OBJECTDIR}/Interrupt generate square wave on rb3.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Interrupt generate square wave on rb3.o\" \"Interrupt generate square wave on rb3.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Interrupt generate square wave on rb3.o"
	@${FIXDEPS} "${OBJECTDIR}/Interrupt generate square wave on rb3.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/5.10.o: 5.10.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/5.10.o.d 
	@${RM} ${OBJECTDIR}/5.10.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/5.10.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/5.10.lst\" -e\"${OBJECTDIR}/5.10.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/5.10.o\" \"5.10.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/5.10.o"
	@${FIXDEPS} "${OBJECTDIR}/5.10.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/tentti\ kysymykset.o: tentti\ kysymykset.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/tentti kysymykset.o".d 
	@${RM} "${OBJECTDIR}/tentti kysymykset.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/tentti kysymykset.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/tentti kysymykset.lst\" -e\"${OBJECTDIR}/tentti kysymykset.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/tentti kysymykset.o\" \"tentti kysymykset.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/tentti kysymykset.o"
	@${FIXDEPS} "${OBJECTDIR}/tentti kysymykset.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Interrupt.o: Interrupt.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/Interrupt.o.d 
	@${RM} ${OBJECTDIR}/Interrupt.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Interrupt.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Interrupt.lst\" -e\"${OBJECTDIR}/Interrupt.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Interrupt.o\" \"Interrupt.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Interrupt.o"
	@${FIXDEPS} "${OBJECTDIR}/Interrupt.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/ADC.o: ADC.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/ADC.o.d 
	@${RM} ${OBJECTDIR}/ADC.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/ADC.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/ADC.lst\" -e\"${OBJECTDIR}/ADC.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/ADC.o\" \"ADC.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/ADC.o"
	@${FIXDEPS} "${OBJECTDIR}/ADC.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/ADC\ with\ interrupt.o: ADC\ with\ interrupt.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/ADC with interrupt.o".d 
	@${RM} "${OBJECTDIR}/ADC with interrupt.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/ADC with interrupt.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/ADC with interrupt.lst\" -e\"${OBJECTDIR}/ADC with interrupt.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/ADC with interrupt.o\" \"ADC with interrupt.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/ADC with interrupt.o"
	@${FIXDEPS} "${OBJECTDIR}/ADC with interrupt.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Dac.o: Dac.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/Dac.o.d 
	@${RM} ${OBJECTDIR}/Dac.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Dac.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Dac.lst\" -e\"${OBJECTDIR}/Dac.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Dac.o\" \"Dac.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Dac.o"
	@${FIXDEPS} "${OBJECTDIR}/Dac.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/C\ language\ Timer.o: C\ language\ Timer.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/C language Timer.o".d 
	@${RM} "${OBJECTDIR}/C language Timer.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/C language Timer.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/C language Timer.lst\" -e\"${OBJECTDIR}/C language Timer.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/C language Timer.o\" \"C language Timer.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/C language Timer.o"
	@${FIXDEPS} "${OBJECTDIR}/C language Timer.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Assigment\ 3.o: Assigment\ 3.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Assigment 3.o".d 
	@${RM} "${OBJECTDIR}/Assigment 3.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Assigment 3.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Assigment 3.lst\" -e\"${OBJECTDIR}/Assigment 3.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Assigment 3.o\" \"Assigment 3.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Assigment 3.o"
	@${FIXDEPS} "${OBJECTDIR}/Assigment 3.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/C\ programming.o: C\ programming.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/C programming.o".d 
	@${RM} "${OBJECTDIR}/C programming.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/C programming.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/C programming.lst\" -e\"${OBJECTDIR}/C programming.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/C programming.o\" \"C programming.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/C programming.o"
	@${FIXDEPS} "${OBJECTDIR}/C programming.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Lab3_Timer.o: Lab3_Timer.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/Lab3_Timer.o.d 
	@${RM} ${OBJECTDIR}/Lab3_Timer.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Lab3_Timer.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Lab3_Timer.lst\" -e\"${OBJECTDIR}/Lab3_Timer.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Lab3_Timer.o\" \"Lab3_Timer.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Lab3_Timer.o"
	@${FIXDEPS} "${OBJECTDIR}/Lab3_Timer.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/newAsmTemplate.o: newAsmTemplate.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/newAsmTemplate.o.d 
	@${RM} ${OBJECTDIR}/newAsmTemplate.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/newAsmTemplate.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -d__DEBUG -d__MPLAB_DEBUGGER_SIMULATOR=1 -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/newAsmTemplate.lst\" -e\"${OBJECTDIR}/newAsmTemplate.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/newAsmTemplate.o\" \"newAsmTemplate.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/newAsmTemplate.o"
	@${FIXDEPS} "${OBJECTDIR}/newAsmTemplate.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
else
${OBJECTDIR}/Lab1_LED.o: Lab1_LED.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/Lab1_LED.o.d 
	@${RM} ${OBJECTDIR}/Lab1_LED.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Lab1_LED.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Lab1_LED.lst\" -e\"${OBJECTDIR}/Lab1_LED.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Lab1_LED.o\" \"Lab1_LED.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Lab1_LED.o"
	@${FIXDEPS} "${OBJECTDIR}/Lab1_LED.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Vähennä\ 2\ 16bit\ numeroa.o: Vähennä\ 2\ 16bit\ numeroa.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Vähennä 2 16bit numeroa.o".d 
	@${RM} "${OBJECTDIR}/Vähennä 2 16bit numeroa.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Vähennä 2 16bit numeroa.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Vähennä 2 16bit numeroa.lst\" -e\"${OBJECTDIR}/Vähennä 2 16bit numeroa.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Vähennä 2 16bit numeroa.o\" \"Vähennä 2 16bit numeroa.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Vähennä 2 16bit numeroa.o"
	@${FIXDEPS} "${OBJECTDIR}/Vähennä 2 16bit numeroa.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/plussaa\ 2\ 16bittistä\ lukua.o: plussaa\ 2\ 16bittistä\ lukua.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/plussaa 2 16bittistä lukua.o".d 
	@${RM} "${OBJECTDIR}/plussaa 2 16bittistä lukua.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/plussaa 2 16bittistä lukua.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/plussaa 2 16bittistä lukua.lst\" -e\"${OBJECTDIR}/plussaa 2 16bittistä lukua.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/plussaa 2 16bittistä lukua.o\" \"plussaa 2 16bittistä lukua.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/plussaa 2 16bittistä lukua.o"
	@${FIXDEPS} "${OBJECTDIR}/plussaa 2 16bittistä lukua.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/kerrotaan\ 16bit\ numero\ 8bit\ numerolla.o: kerrotaan\ 16bit\ numero\ 8bit\ numerolla.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.o".d 
	@${RM} "${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.lst\" -e\"${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.o\" \"kerrotaan 16bit numero 8bit numerolla.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.o"
	@${FIXDEPS} "${OBJECTDIR}/kerrotaan 16bit numero 8bit numerolla.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Kerro\ 2\ 8bit\ numeroa.\ oleta\ että\ numerot\ ovat\ 2complementissa.o: Kerro\ 2\ 8bit\ numeroa.\ oleta\ että\ numerot\ ovat\ 2complementissa.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.o".d 
	@${RM} "${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.lst\" -e\"${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.o\" \"Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.o"
	@${FIXDEPS} "${OBJECTDIR}/Kerro 2 8bit numeroa. oleta että numerot ovat 2complementissa.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/kierrätä\ bitit.o: kierrätä\ bitit.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/kierrätä bitit.o".d 
	@${RM} "${OBJECTDIR}/kierrätä bitit.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/kierrätä bitit.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/kierrätä bitit.lst\" -e\"${OBJECTDIR}/kierrätä bitit.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/kierrätä bitit.o\" \"kierrätä bitit.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/kierrätä bitit.o"
	@${FIXDEPS} "${OBJECTDIR}/kierrätä bitit.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/BCDbyte\ kahteen\ rekisteriin\ ja\ lähetä\ ne\ porttia\ ja\ b.o: BCDbyte\ kahteen\ rekisteriin\ ja\ lähetä\ ne\ porttia\ ja\ b.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.o".d 
	@${RM} "${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.lst\" -e\"${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.o\" \"BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.o"
	@${FIXDEPS} "${OBJECTDIR}/BCDbyte kahteen rekisteriin ja lähetä ne porttia ja b.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/kaksi\ microcontrolleria\ yhdistetty\ portB0.o: kaksi\ microcontrolleria\ yhdistetty\ portB0.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.o".d 
	@${RM} "${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.lst\" -e\"${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.o\" \"kaksi microcontrolleria yhdistetty portB0.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.o"
	@${FIXDEPS} "${OBJECTDIR}/kaksi microcontrolleria yhdistetty portB0.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/XOR\ of\ bits.o: XOR\ of\ bits.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/XOR of bits.o".d 
	@${RM} "${OBJECTDIR}/XOR of bits.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/XOR of bits.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/XOR of bits.lst\" -e\"${OBJECTDIR}/XOR of bits.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/XOR of bits.o\" \"XOR of bits.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/XOR of bits.o"
	@${FIXDEPS} "${OBJECTDIR}/XOR of bits.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Exam\ questions.o: Exam\ questions.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Exam questions.o".d 
	@${RM} "${OBJECTDIR}/Exam questions.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Exam questions.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Exam questions.lst\" -e\"${OBJECTDIR}/Exam questions.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Exam questions.o\" \"Exam questions.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Exam questions.o"
	@${FIXDEPS} "${OBJECTDIR}/Exam questions.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/timer-\ tee\ 50\ duty\ cycle\ porttiinB5.o: timer-\ tee\ 50\ duty\ cycle\ porttiinB5.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.o".d 
	@${RM} "${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.lst\" -e\"${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.o\" \"timer- tee 50 duty cycle porttiinB5.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.o"
	@${FIXDEPS} "${OBJECTDIR}/timer- tee 50 duty cycle porttiinB5.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/timer\ -\ wave\ square\ wave\ 10ms\ period\ pinniin\ PORTB%.o: timer\ -\ wave\ square\ wave\ 10ms\ period\ pinniin\ PORTB%.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.o".d 
	@${RM} "${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.lst\" -e\"${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.o\" \"timer - wave square wave 10ms period pinniin PORTB%.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.o"
	@${FIXDEPS} "${OBJECTDIR}/timer - wave square wave 10ms period pinniin PORTB%.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Timer\ calculate\ delay.o: Timer\ calculate\ delay.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Timer calculate delay.o".d 
	@${RM} "${OBJECTDIR}/Timer calculate delay.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Timer calculate delay.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Timer calculate delay.lst\" -e\"${OBJECTDIR}/Timer calculate delay.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Timer calculate delay.o\" \"Timer calculate delay.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Timer calculate delay.o"
	@${FIXDEPS} "${OBJECTDIR}/Timer calculate delay.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Timer\ -\ generate\ pulse\ with\ freguency\ 1devided160.o: Timer\ -\ generate\ pulse\ with\ freguency\ 1devided160.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.o".d 
	@${RM} "${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.lst\" -e\"${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.o\" \"Timer - generate pulse with freguency 1devided160.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.o"
	@${FIXDEPS} "${OBJECTDIR}/Timer - generate pulse with freguency 1devided160.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Timer\ program\ to\ measure\ RPS\ of\ wheel\ send\ to\ PortD.o: Timer\ program\ to\ measure\ RPS\ of\ wheel\ send\ to\ PortD.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.o".d 
	@${RM} "${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.lst\" -e\"${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.o\" \"Timer program to measure RPS of wheel send to PortD.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.o"
	@${FIXDEPS} "${OBJECTDIR}/Timer program to measure RPS of wheel send to PortD.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Prescaler\ and\ postscaler.o: Prescaler\ and\ postscaler.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Prescaler and postscaler.o".d 
	@${RM} "${OBJECTDIR}/Prescaler and postscaler.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Prescaler and postscaler.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Prescaler and postscaler.lst\" -e\"${OBJECTDIR}/Prescaler and postscaler.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Prescaler and postscaler.o\" \"Prescaler and postscaler.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Prescaler and postscaler.o"
	@${FIXDEPS} "${OBJECTDIR}/Prescaler and postscaler.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Interrupt\ generate\ square\ wave\ on\ rb3.o: Interrupt\ generate\ square\ wave\ on\ rb3.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Interrupt generate square wave on rb3.o".d 
	@${RM} "${OBJECTDIR}/Interrupt generate square wave on rb3.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Interrupt generate square wave on rb3.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Interrupt generate square wave on rb3.lst\" -e\"${OBJECTDIR}/Interrupt generate square wave on rb3.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Interrupt generate square wave on rb3.o\" \"Interrupt generate square wave on rb3.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Interrupt generate square wave on rb3.o"
	@${FIXDEPS} "${OBJECTDIR}/Interrupt generate square wave on rb3.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/5.10.o: 5.10.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/5.10.o.d 
	@${RM} ${OBJECTDIR}/5.10.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/5.10.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/5.10.lst\" -e\"${OBJECTDIR}/5.10.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/5.10.o\" \"5.10.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/5.10.o"
	@${FIXDEPS} "${OBJECTDIR}/5.10.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/tentti\ kysymykset.o: tentti\ kysymykset.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/tentti kysymykset.o".d 
	@${RM} "${OBJECTDIR}/tentti kysymykset.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/tentti kysymykset.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/tentti kysymykset.lst\" -e\"${OBJECTDIR}/tentti kysymykset.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/tentti kysymykset.o\" \"tentti kysymykset.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/tentti kysymykset.o"
	@${FIXDEPS} "${OBJECTDIR}/tentti kysymykset.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Interrupt.o: Interrupt.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/Interrupt.o.d 
	@${RM} ${OBJECTDIR}/Interrupt.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Interrupt.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Interrupt.lst\" -e\"${OBJECTDIR}/Interrupt.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Interrupt.o\" \"Interrupt.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Interrupt.o"
	@${FIXDEPS} "${OBJECTDIR}/Interrupt.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/ADC.o: ADC.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/ADC.o.d 
	@${RM} ${OBJECTDIR}/ADC.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/ADC.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/ADC.lst\" -e\"${OBJECTDIR}/ADC.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/ADC.o\" \"ADC.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/ADC.o"
	@${FIXDEPS} "${OBJECTDIR}/ADC.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/ADC\ with\ interrupt.o: ADC\ with\ interrupt.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/ADC with interrupt.o".d 
	@${RM} "${OBJECTDIR}/ADC with interrupt.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/ADC with interrupt.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/ADC with interrupt.lst\" -e\"${OBJECTDIR}/ADC with interrupt.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/ADC with interrupt.o\" \"ADC with interrupt.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/ADC with interrupt.o"
	@${FIXDEPS} "${OBJECTDIR}/ADC with interrupt.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Dac.o: Dac.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/Dac.o.d 
	@${RM} ${OBJECTDIR}/Dac.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Dac.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Dac.lst\" -e\"${OBJECTDIR}/Dac.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Dac.o\" \"Dac.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Dac.o"
	@${FIXDEPS} "${OBJECTDIR}/Dac.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/C\ language\ Timer.o: C\ language\ Timer.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/C language Timer.o".d 
	@${RM} "${OBJECTDIR}/C language Timer.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/C language Timer.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/C language Timer.lst\" -e\"${OBJECTDIR}/C language Timer.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/C language Timer.o\" \"C language Timer.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/C language Timer.o"
	@${FIXDEPS} "${OBJECTDIR}/C language Timer.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Assigment\ 3.o: Assigment\ 3.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/Assigment 3.o".d 
	@${RM} "${OBJECTDIR}/Assigment 3.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Assigment 3.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Assigment 3.lst\" -e\"${OBJECTDIR}/Assigment 3.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Assigment 3.o\" \"Assigment 3.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Assigment 3.o"
	@${FIXDEPS} "${OBJECTDIR}/Assigment 3.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/C\ programming.o: C\ programming.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} "${OBJECTDIR}/C programming.o".d 
	@${RM} "${OBJECTDIR}/C programming.o" 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/C programming.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/C programming.lst\" -e\"${OBJECTDIR}/C programming.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/C programming.o\" \"C programming.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/C programming.o"
	@${FIXDEPS} "${OBJECTDIR}/C programming.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/Lab3_Timer.o: Lab3_Timer.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/Lab3_Timer.o.d 
	@${RM} ${OBJECTDIR}/Lab3_Timer.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/Lab3_Timer.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/Lab3_Timer.lst\" -e\"${OBJECTDIR}/Lab3_Timer.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/Lab3_Timer.o\" \"Lab3_Timer.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/Lab3_Timer.o"
	@${FIXDEPS} "${OBJECTDIR}/Lab3_Timer.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
${OBJECTDIR}/newAsmTemplate.o: newAsmTemplate.asm  nbproject/Makefile-${CND_CONF}.mk
	@${MKDIR} "${OBJECTDIR}" 
	@${RM} ${OBJECTDIR}/newAsmTemplate.o.d 
	@${RM} ${OBJECTDIR}/newAsmTemplate.o 
	@${FIXDEPS} dummy.d -e "${OBJECTDIR}/newAsmTemplate.err" $(SILENT) -c ${MP_AS} $(MP_EXTRA_AS_PRE) -q -p$(MP_PROCESSOR_OPTION)  -l\"${OBJECTDIR}/newAsmTemplate.lst\" -e\"${OBJECTDIR}/newAsmTemplate.err\" $(ASM_OPTIONS)    -o\"${OBJECTDIR}/newAsmTemplate.o\" \"newAsmTemplate.asm\" 
	@${DEP_GEN} -d "${OBJECTDIR}/newAsmTemplate.o"
	@${FIXDEPS} "${OBJECTDIR}/newAsmTemplate.o.d" $(SILENT) -rsi ${MP_AS_DIR} -c18 
	
endif

# ------------------------------------------------------------------------------------
# Rules for buildStep: link
ifeq ($(TYPE_IMAGE), DEBUG_RUN)
dist/${CND_CONF}/${IMAGE_TYPE}/Lab_1.X.${IMAGE_TYPE}.${OUTPUT_SUFFIX}: ${OBJECTFILES}  nbproject/Makefile-${CND_CONF}.mk    
	@${MKDIR} dist/${CND_CONF}/${IMAGE_TYPE} 
	${MP_LD} $(MP_EXTRA_LD_PRE)   -p$(MP_PROCESSOR_OPTION)  -w -x -u_DEBUG -z__ICD2RAM=1 -m"${DISTDIR}/${PROJECTNAME}.${IMAGE_TYPE}.map"   -z__MPLAB_BUILD=1  -z__MPLAB_DEBUG=1 -z__MPLAB_DEBUGGER_SIMULATOR=1 $(MP_LINKER_DEBUG_OPTION) -odist/${CND_CONF}/${IMAGE_TYPE}/Lab_1.X.${IMAGE_TYPE}.${OUTPUT_SUFFIX}  ${OBJECTFILES_QUOTED_IF_SPACED}     
else
dist/${CND_CONF}/${IMAGE_TYPE}/Lab_1.X.${IMAGE_TYPE}.${OUTPUT_SUFFIX}: ${OBJECTFILES}  nbproject/Makefile-${CND_CONF}.mk   
	@${MKDIR} dist/${CND_CONF}/${IMAGE_TYPE} 
	${MP_LD} $(MP_EXTRA_LD_PRE)   -p$(MP_PROCESSOR_OPTION)  -w  -m"${DISTDIR}/${PROJECTNAME}.${IMAGE_TYPE}.map"   -z__MPLAB_BUILD=1  -odist/${CND_CONF}/${IMAGE_TYPE}/Lab_1.X.${IMAGE_TYPE}.${DEBUGGABLE_SUFFIX}  ${OBJECTFILES_QUOTED_IF_SPACED}     
endif


# Subprojects
.build-subprojects:


# Subprojects
.clean-subprojects:

# Clean Targets
.clean-conf: ${CLEAN_SUBPROJECTS}
	${RM} -r build/default
	${RM} -r dist/default

# Enable dependency checking
.dep.inc: .depcheck-impl

DEPFILES=$(shell mplabwildcard ${POSSIBLE_DEPFILES})
ifneq (${DEPFILES},)
include ${DEPFILES}
endif
