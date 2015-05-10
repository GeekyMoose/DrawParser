/* The following code was generated by JFlex 1.4.3 on 5/10/15 2:45 PM */


package com.parser.asset;
import com.exceptions.LexerException;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 5/10/15 2:45 PM from the specification file
 * <tt>flexParsing.flex</tt>
 */
public class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int IN_BLOCK_COMMENT = 2;
  public static final int IN_LINE_COMMENT = 4;
  public static final int YYINITIAL = 0;
  public static final int IN_STR = 6;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  3, 3
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\2\1\4\2\0\1\3\22\0\1\1\1\0\1\47\5\0"+
    "\1\52\1\53\1\51\1\57\1\0\1\60\1\0\1\50\12\27\1\0"+
    "\1\56\1\0\1\30\3\0\1\23\2\26\1\44\1\34\7\26\1\32"+
    "\1\46\1\33\1\41\1\26\1\24\1\26\1\36\1\40\1\22\1\45"+
    "\3\26\1\0\1\61\2\0\1\26\1\0\1\21\2\25\1\42\1\13"+
    "\1\12\1\10\1\17\1\11\2\25\1\14\1\31\1\43\1\7\1\5"+
    "\1\25\1\6\1\15\1\35\1\37\1\20\1\16\3\25\1\54\1\0"+
    "\1\55\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\4\0\1\1\3\2\10\3\2\1\1\4\1\5\1\3"+
    "\1\1\1\3\1\1\1\3\1\1\1\6\1\7\1\10"+
    "\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\2"+
    "\1\20\1\2\2\3\1\21\4\3\4\0\1\22\1\3"+
    "\2\0\2\23\1\3\2\0\1\24\1\25\2\3\1\26"+
    "\3\3\2\27\2\0\1\3\2\0\1\3\2\0\1\30"+
    "\1\3\1\31\1\32\1\3\2\0\2\33\2\34\1\3"+
    "\1\0\1\35\2\0\1\36\1\0\1\36\1\31";

  private static int [] zzUnpackAction() {
    int [] result = new int[97];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\62\0\144\0\226\0\310\0\310\0\372\0\u012c"+
    "\0\u015e\0\u0190\0\u01c2\0\u01f4\0\u0226\0\u0258\0\u028a\0\u02bc"+
    "\0\u02ee\0\u0320\0\u0352\0\u0384\0\u03b6\0\u03e8\0\u041a\0\u044c"+
    "\0\u047e\0\u04b0\0\310\0\u04e2\0\310\0\310\0\310\0\310"+
    "\0\310\0\310\0\310\0\310\0\u0514\0\310\0\u0546\0\u0578"+
    "\0\u05aa\0\u01c2\0\u05dc\0\u060e\0\u0640\0\u0672\0\u06a4\0\u06d6"+
    "\0\u0708\0\u073a\0\310\0\u076c\0\u079e\0\u07d0\0\u01c2\0\310"+
    "\0\u0802\0\u0834\0\u0866\0\310\0\310\0\u0898\0\u08ca\0\u01c2"+
    "\0\u08fc\0\u092e\0\u0960\0\u01c2\0\310\0\u0992\0\u09c4\0\u09f6"+
    "\0\u0a28\0\u0a5a\0\u0a8c\0\u0abe\0\u0af0\0\u01c2\0\u0b22\0\u01c2"+
    "\0\u0b54\0\u0b86\0\u0bb8\0\u0bea\0\u01c2\0\310\0\u01c2\0\310"+
    "\0\u0c1c\0\u0c4e\0\u01c2\0\u0c80\0\u0cb2\0\u01c2\0\u0ce4\0\310"+
    "\0\310";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[97];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\5\2\6\1\7\1\10\1\11\1\12\2\13\1\14"+
    "\1\15\1\16\2\13\1\17\1\13\1\20\1\13\1\21"+
    "\1\5\1\22\1\13\1\5\1\23\1\24\1\25\1\26"+
    "\2\5\1\13\1\5\1\27\1\30\1\5\1\31\1\13"+
    "\1\32\2\5\1\33\1\34\1\35\1\36\1\37\1\40"+
    "\1\41\1\42\1\43\1\44\1\5\51\6\1\45\14\6"+
    "\1\46\61\6\1\0\42\6\1\46\11\6\1\47\66\0"+
    "\1\6\60\0\1\6\63\0\1\13\1\50\20\13\2\0"+
    "\16\13\20\0\2\13\1\51\17\13\2\0\16\13\20\0"+
    "\22\13\2\0\16\13\20\0\5\13\1\52\14\13\2\0"+
    "\16\13\20\0\2\13\1\53\17\13\2\0\16\13\20\0"+
    "\7\13\1\54\12\13\2\0\16\13\20\0\12\13\1\55"+
    "\7\13\2\0\16\13\20\0\14\13\1\56\5\13\2\0"+
    "\16\13\34\0\1\57\1\0\1\60\45\0\1\61\23\0"+
    "\1\62\55\0\1\23\62\0\1\63\36\0\2\13\1\64"+
    "\17\13\2\0\16\13\22\0\1\65\23\0\1\66\33\0"+
    "\1\67\21\13\2\0\16\13\20\0\1\70\33\0\1\70"+
    "\25\0\2\13\1\71\17\13\2\0\16\13\22\0\1\72"+
    "\23\0\1\73\76\0\1\74\1\75\60\0\1\46\60\0"+
    "\1\6\17\0\2\13\1\76\17\13\2\0\16\13\20\0"+
    "\22\13\2\0\4\13\1\77\11\13\20\0\1\13\1\100"+
    "\20\13\2\0\16\13\20\0\4\13\1\101\3\13\1\102"+
    "\11\13\2\0\16\13\20\0\4\13\1\103\15\13\2\0"+
    "\16\13\20\0\1\13\1\104\20\13\2\0\16\13\21\0"+
    "\1\105\77\0\1\105\72\0\1\106\62\0\1\107\30\0"+
    "\13\13\1\110\6\13\2\0\16\13\33\0\1\111\63\0"+
    "\1\112\44\0\11\13\1\113\10\13\2\0\16\13\31\0"+
    "\1\114\110\0\1\115\21\0\3\13\1\116\16\13\2\0"+
    "\16\13\20\0\14\13\1\117\5\13\2\0\16\13\20\0"+
    "\5\13\1\120\14\13\2\0\16\13\20\0\6\13\1\121"+
    "\13\13\2\0\16\13\20\0\7\13\1\122\12\13\2\0"+
    "\16\13\34\0\1\123\63\0\1\124\43\0\6\13\1\125"+
    "\13\13\2\0\16\13\26\0\1\126\102\0\1\126\32\0"+
    "\22\13\2\0\12\13\1\127\3\13\56\0\1\130\64\0"+
    "\1\130\20\0\22\13\2\0\4\13\1\131\11\13\14\0"+
    "\1\132\3\0\22\13\2\0\16\13\20\0\6\13\1\133"+
    "\13\13\2\0\16\13\50\0\1\134\62\0\1\135\30\0"+
    "\6\13\1\136\13\13\2\0\16\13\24\0\1\137\63\0"+
    "\1\140\102\0\1\140\37\0\1\141\47\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3350];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\4\0\2\11\24\1\1\11\1\1\10\11\1\1\1\11"+
    "\10\1\4\0\1\11\1\1\2\0\1\1\1\11\1\1"+
    "\2\0\2\11\7\1\1\11\2\0\1\1\2\0\1\1"+
    "\2\0\5\1\2\0\1\1\1\11\1\1\1\11\1\1"+
    "\1\0\1\1\2\0\1\1\1\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[97];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    /*
     * NOTE : 
     * yyline start at 0, actual line is yyline + 1
     */
    
  	private Token getToken(Sym type) {
      	return new Token(type, yyline+1);
  	}

  	private IntToken getToken(Sym pType, int pValue) {
      	return new IntToken(pType, yyline+1, pValue);
  	}

    private StrToken getToken(Sym pType, String pValue){
        return new StrToken(pType, yyline+1, pValue);
    }

    public int getLine(){
        return yyline+1;
    }

    public int getColumn(){
        return yycolumn+1;
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 144) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Token yylex() throws java.io.IOException, 	LexerException
 {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 8: 
          { return getToken(Sym.MULTIPLY);
          }
        case 31: break;
        case 23: 
          { return getToken(Sym.VAR_CREA);
          }
        case 32: break;
        case 6: 
          { yybegin(IN_STR);
          }
        case 33: break;
        case 9: 
          { return getToken(Sym.L_PAR);
          }
        case 34: break;
        case 13: 
          { return getToken(Sym.CONCAT);
          }
        case 35: break;
        case 1: 
          { throw new LexerException(yytext(), yyline+1, yycolumn+1);
          }
        case 36: break;
        case 26: 
          { return getToken(Sym.ELSE);
          }
        case 37: break;
        case 30: 
          { return getToken(Sym.ROTATE);
          }
        case 38: break;
        case 22: 
          { return getToken(Sym.FOR);
          }
        case 39: break;
        case 21: 
          { yybegin(IN_BLOCK_COMMENT);
          }
        case 40: break;
        case 17: 
          { return getToken(Sym.IF);
          }
        case 41: break;
        case 16: 
          { yybegin(YYINITIAL);
          }
        case 42: break;
        case 25: 
          { return getToken(Sym.ELIF);
          }
        case 43: break;
        case 20: 
          { yybegin(IN_LINE_COMMENT);
          }
        case 44: break;
        case 3: 
          { return getToken(Sym.VAR_NAME, String.valueOf(yytext()));
          }
        case 45: break;
        case 7: 
          { return getToken(Sym.DIV);
          }
        case 46: break;
        case 4: 
          { return getToken(Sym.NUMBER_INT, Integer.valueOf(yytext()));
          }
        case 47: break;
        case 28: 
          { return getToken(Sym.DOWN);
          }
        case 48: break;
        case 27: 
          { return getToken(Sym.MOVE);
          }
        case 49: break;
        case 15: 
          { return getToken(Sym.LESS);
          }
        case 50: break;
        case 12: 
          { return getToken(Sym.R_CB);
          }
        case 51: break;
        case 19: 
          { return getToken(Sym.UP);
          }
        case 52: break;
        case 14: 
          { return getToken(Sym.PLUS);
          }
        case 53: break;
        case 29: 
          { return getToken(Sym.WHILE);
          }
        case 54: break;
        case 18: 
          { return getToken(Sym.EQ);
          }
        case 55: break;
        case 11: 
          { return getToken(Sym.L_CB);
          }
        case 56: break;
        case 10: 
          { return getToken(Sym.R_PAR);
          }
        case 57: break;
        case 24: 
          { return getToken(Sym.PROG);
          }
        case 58: break;
        case 5: 
          { return getToken(Sym.ASSIGN);
          }
        case 59: break;
        case 2: 
          { 
          }
        case 60: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            switch (zzLexicalState) {
            case YYINITIAL: {
              return getToken(Sym.EOF);
            }
            case 98: break;
            default:
            return null;
            }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
