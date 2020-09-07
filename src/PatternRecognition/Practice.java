package PatternRecognition;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Practice {
	public void practice(String folder,String filename,String val) throws IOException {
		File f=new File("trainingSample//trainingSample//"+folder+"//"+filename);
		BufferedImage tns=new BufferedImage(28,28,BufferedImage.TYPE_INT_RGB);
		FileWriter fw=null;
		try {
			fw=new FileWriter("TrainLog.txt",true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			tns=ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<28;i++) {
			for(int j=0;j<28;j++) {
				int pixel=tns.getRGB(j,i) & 0xFF;
				pixel=pixel>145 ? 1 : 0;
				val=val+","+pixel;
			}
		}
		
		try {
			fw.append(val+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fw.close();
		
	}
	public static void main(String[] args) throws IOException {
		Practice p=new Practice();
		String[] zero= {"img_1.jpg", "img_108.jpg", "img_110.jpg", "img_111.jpg", "img_114.jpg", "img_129.jpg", "img_141.jpg", "img_146.jpg", "img_149.jpg", "img_153.jpg", "img_157.jpg", "img_17.jpg", "img_183.jpg", "img_188.jpg", "img_193.jpg", "img_195.jpg", "img_196.jpg", "img_200.jpg", "img_201.jpg", "img_203.jpg", "img_204.jpg", "img_23.jpg", "img_248.jpg", "img_251.jpg", "img_260.jpg", "img_264.jpg", "img_267.jpg", "img_272.jpg", "img_273.jpg", "img_276.jpg", "img_279.jpg", "img_285.jpg", "img_286.jpg", "img_288.jpg", "img_292.jpg", "img_322.jpg", "img_327.jpg", "img_344.jpg", "img_357.jpg", "img_366.jpg", "img_373.jpg", "img_375.jpg", "img_4.jpg", "img_403.jpg", "img_404.jpg", "img_412.jpg", "img_418.jpg", "img_433.jpg", "img_435.jpg", "img_472.jpg", "img_486.jpg", "img_5.jpg", "img_502.jpg", "img_508.jpg", "img_538.jpg", "img_54.jpg", "img_542.jpg", "img_63.jpg", "img_69.jpg", "img_98.jpg"};
		String[] ones= {"img_0.jpg", "img_118.jpg", "img_12.jpg", "img_124.jpg", "img_134.jpg", "img_140.jpg", "img_15.jpg", "img_152.jpg", "img_182.jpg", "img_185.jpg", "img_191.jpg", "img_2.jpg", "img_209.jpg", "img_221.jpg", "img_224.jpg", "img_249.jpg", "img_255.jpg", "img_256.jpg", "img_257.jpg", "img_281.jpg", "img_295.jpg", "img_335.jpg", "img_342.jpg", "img_35.jpg", "img_37.jpg", "img_371.jpg", "img_38.jpg", "img_380.jpg", "img_388.jpg", "img_400.jpg", "img_401.jpg", "img_41.jpg", "img_424.jpg", "img_426.jpg", "img_451.jpg", "img_468.jpg", "img_476.jpg", "img_480.jpg", "img_484.jpg", "img_491.jpg", "img_495.jpg", "img_497.jpg", "img_52.jpg", "img_522.jpg", "img_527.jpg", "img_529.jpg", "img_540.jpg", "img_544.jpg", "img_549.jpg", "img_584.jpg", "img_59.jpg", "img_590.jpg", "img_594.jpg", "img_598.jpg", "img_60.jpg", "img_61.jpg", "img_68.jpg", "img_77.jpg", "img_79.jpg", "img_96.jpg"};
		String[] twos= {"img_101.jpg", "img_104.jpg", "img_112.jpg", "img_16.jpg", "img_169.jpg", "img_178.jpg", "img_190.jpg", "img_199.jpg", "img_207.jpg", "img_22.jpg", "img_233.jpg", "img_235.jpg", "img_236.jpg", "img_239.jpg", "img_24.jpg", "img_241.jpg", "img_247.jpg", "img_261.jpg", "img_263.jpg", "img_271.jpg", "img_275.jpg", "img_278.jpg", "img_287.jpg", "img_294.jpg", "img_298.jpg", "img_302.jpg", "img_306.jpg", "img_312.jpg", "img_324.jpg", "img_34.jpg", "img_341.jpg", "img_348.jpg", "img_353.jpg", "img_354.jpg", "img_355.jpg", "img_360.jpg", "img_361.jpg", "img_365.jpg", "img_370.jpg", "img_383.jpg", "img_397.jpg", "img_410.jpg", "img_413.jpg", "img_432.jpg", "img_438.jpg", "img_44.jpg", "img_444.jpg", "img_459.jpg", "img_462.jpg", "img_463.jpg", "img_465.jpg", "img_473.jpg", "img_474.jpg", "img_477.jpg", "img_55.jpg", "img_56.jpg", "img_73.jpg", "img_84.jpg", "img_94.jpg", "img_97.jpg"};
		String[] threes= {"img_13.jpg", "img_137.jpg", "img_139.jpg", "img_14.jpg", "img_142.jpg", "img_150.jpg", "img_155.jpg", "img_166.jpg", "img_181.jpg", "img_192.jpg", "img_198.jpg", "img_212.jpg", "img_219.jpg", "img_225.jpg", "img_228.jpg", "img_230.jpg", "img_232.jpg", "img_234.jpg", "img_240.jpg", "img_25.jpg", "img_253.jpg", "img_284.jpg", "img_311.jpg", "img_314.jpg", "img_316.jpg", "img_320.jpg", "img_333.jpg", "img_334.jpg", "img_36.jpg", "img_363.jpg", "img_379.jpg", "img_387.jpg", "img_392.jpg", "img_394.jpg", "img_417.jpg", "img_431.jpg", "img_458.jpg", "img_46.jpg", "img_470.jpg", "img_481.jpg", "img_489.jpg", "img_492.jpg", "img_510.jpg", "img_537.jpg", "img_560.jpg", "img_565.jpg", "img_568.jpg", "img_57.jpg", "img_581.jpg", "img_596.jpg", "img_597.jpg", "img_606.jpg", "img_610.jpg", "img_615.jpg", "img_619.jpg", "img_65.jpg", "img_7.jpg", "img_70.jpg", "img_9.jpg", "img_90.jpg"};
		String[] fours= {"img_115.jpg", "img_122.jpg", "img_130.jpg", "img_143.jpg", "img_145.jpg", "img_148.jpg", "img_163.jpg", "img_168.jpg", "img_170.jpg", "img_184.jpg", "img_205.jpg", "img_215.jpg", "img_250.jpg", "img_258.jpg", "img_277.jpg", "img_291.jpg", "img_299.jpg", "img_3.jpg", "img_309.jpg", "img_32.jpg", "img_329.jpg", "img_332.jpg", "img_351.jpg", "img_364.jpg", "img_376.jpg", "img_378.jpg", "img_382.jpg", "img_39.jpg", "img_390.jpg", "img_398.jpg", "img_402.jpg", "img_409.jpg", "img_415.jpg", "img_42.jpg", "img_420.jpg", "img_423.jpg", "img_428.jpg", "img_43.jpg", "img_430.jpg", "img_445.jpg", "img_446.jpg", "img_448.jpg", "img_450.jpg", "img_467.jpg", "img_482.jpg", "img_49.jpg", "img_490.jpg", "img_494.jpg", "img_496.jpg", "img_516.jpg", "img_524.jpg", "img_530.jpg", "img_531.jpg", "img_541.jpg", "img_548.jpg", "img_66.jpg", "img_75.jpg", "img_78.jpg", "img_81.jpg", "img_92.jpg"};
		String[] fives= {"img_107.jpg", "img_119.jpg", "img_125.jpg", "img_128.jpg", "img_144.jpg", "img_147.jpg", "img_151.jpg", "img_162.jpg", "img_167.jpg", "img_174.jpg", "img_186.jpg", "img_19.jpg", "img_218.jpg", "img_243.jpg", "img_244.jpg", "img_265.jpg", "img_297.jpg", "img_301.jpg", "img_328.jpg", "img_330.jpg", "img_345.jpg", "img_347.jpg", "img_350.jpg", "img_367.jpg", "img_381.jpg", "img_385.jpg", "img_389.jpg", "img_391.jpg", "img_405.jpg", "img_414.jpg", "img_427.jpg", "img_434.jpg", "img_443.jpg", "img_453.jpg", "img_456.jpg", "img_460.jpg", "img_498.jpg", "img_503.jpg", "img_51.jpg", "img_511.jpg", "img_518.jpg", "img_525.jpg", "img_526.jpg", "img_533.jpg", "img_539.jpg", "img_543.jpg", "img_557.jpg", "img_561.jpg", "img_569.jpg", "img_571.jpg", "img_580.jpg", "img_587.jpg", "img_589.jpg", "img_602.jpg", "img_62.jpg", "img_626.jpg", "img_651.jpg", "img_8.jpg", "img_80.jpg", "img_99.jpg"};
		String[] sixes= {"img_109.jpg", "img_123.jpg", "img_127.jpg", "img_133.jpg", "img_159.jpg", "img_160.jpg", "img_164.jpg", "img_179.jpg", "img_189.jpg", "img_194.jpg", "img_202.jpg", "img_21.jpg", "img_216.jpg", "img_217.jpg", "img_227.jpg", "img_229.jpg", "img_231.jpg", "img_252.jpg", "img_26.jpg", "img_266.jpg", "img_270.jpg", "img_282.jpg", "img_289.jpg", "img_315.jpg", "img_317.jpg", "img_340.jpg", "img_346.jpg", "img_352.jpg", "img_362.jpg", "img_369.jpg", "img_374.jpg", "img_396.jpg", "img_399.jpg", "img_407.jpg", "img_419.jpg", "img_422.jpg", "img_442.jpg", "img_447.jpg", "img_45.jpg", "img_471.jpg", "img_500.jpg", "img_505.jpg", "img_532.jpg", "img_550.jpg", "img_570.jpg", "img_583.jpg", "img_591.jpg", "img_595.jpg", "img_604.jpg", "img_607.jpg", "img_625.jpg", "img_630.jpg", "img_634.jpg", "img_64.jpg", "img_659.jpg", "img_72.jpg", "img_74.jpg", "img_89.jpg", "img_91.jpg", "img_93.jpg"};
		String[] sevens= {"img_102.jpg", "img_103.jpg", "img_116.jpg", "img_117.jpg", "img_120.jpg", "img_126.jpg", "img_132.jpg", "img_136.jpg", "img_138.jpg", "img_156.jpg", "img_172.jpg", "img_173.jpg", "img_18.jpg", "img_206.jpg", "img_208.jpg", "img_223.jpg", "img_226.jpg", "img_237.jpg", "img_242.jpg", "img_254.jpg", "img_259.jpg", "img_274.jpg", "img_29.jpg", "img_293.jpg", "img_304.jpg", "img_308.jpg", "img_313.jpg", "img_321.jpg", "img_325.jpg", "img_336.jpg", "img_339.jpg", "img_343.jpg", "img_358.jpg", "img_359.jpg", "img_386.jpg", "img_393.jpg", "img_408.jpg", "img_436.jpg", "img_452.jpg", "img_464.jpg", "img_47.jpg", "img_478.jpg", "img_48.jpg", "img_493.jpg", "img_50.jpg", "img_504.jpg", "img_509.jpg", "img_521.jpg", "img_573.jpg", "img_578.jpg", "img_582.jpg", "img_586.jpg", "img_593.jpg", "img_6.jpg", "img_608.jpg", "img_609.jpg", "img_613.jpg", "img_620.jpg", "img_654.jpg", "img_76.jpg"};
		String[] eights= {"img_10.jpg", "img_105.jpg", "img_106.jpg", "img_131.jpg", "img_135.jpg", "img_154.jpg", "img_171.jpg", "img_175.jpg", "img_176.jpg", "img_177.jpg", "img_197.jpg", "img_20.jpg", "img_214.jpg", "img_220.jpg", "img_222.jpg", "img_245.jpg", "img_246.jpg", "img_268.jpg", "img_290.jpg", "img_30.jpg", "img_300.jpg", "img_318.jpg", "img_319.jpg", "img_331.jpg", "img_337.jpg", "img_377.jpg", "img_395.jpg", "img_406.jpg", "img_411.jpg", "img_416.jpg", "img_421.jpg", "img_425.jpg", "img_440.jpg", "img_449.jpg", "img_454.jpg", "img_461.jpg", "img_466.jpg", "img_485.jpg", "img_506.jpg", "img_512.jpg", "img_514.jpg", "img_517.jpg", "img_519.jpg", "img_528.jpg", "img_534.jpg", "img_551.jpg", "img_605.jpg", "img_611.jpg", "img_618.jpg", "img_629.jpg", "img_637.jpg", "img_639.jpg", "img_640.jpg", "img_647.jpg", "img_653.jpg", "img_67.jpg", "img_672.jpg", "img_674.jpg", "img_82.jpg", "img_87.jpg"};
		String[] nines= {"img_100.jpg", "img_11.jpg", "img_113.jpg", "img_121.jpg", "img_158.jpg", "img_161.jpg", "img_165.jpg", "img_180.jpg", "img_187.jpg", "img_210.jpg", "img_211.jpg", "img_213.jpg", "img_238.jpg", "img_262.jpg", "img_269.jpg", "img_27.jpg", "img_28.jpg", "img_280.jpg", "img_283.jpg", "img_296.jpg", "img_303.jpg", "img_305.jpg", "img_307.jpg", "img_31.jpg", "img_310.jpg", "img_323.jpg", "img_326.jpg", "img_33.jpg", "img_338.jpg", "img_349.jpg", "img_356.jpg", "img_368.jpg", "img_372.jpg", "img_384.jpg", "img_40.jpg", "img_429.jpg", "img_437.jpg", "img_439.jpg", "img_441.jpg", "img_455.jpg", "img_457.jpg", "img_469.jpg", "img_475.jpg", "img_483.jpg", "img_499.jpg", "img_501.jpg", "img_520.jpg", "img_53.jpg", "img_535.jpg", "img_546.jpg", "img_554.jpg", "img_558.jpg", "img_562.jpg", "img_58.jpg", "img_71.jpg", "img_83.jpg", "img_85.jpg", "img_86.jpg", "img_88.jpg", "img_95.jpg"};
	    for(int i=0;i<60;i++) {
	    	p.practice("0",zero[i],"0");
	    	p.practice("1",ones[i],"1");
	    	p.practice("2",twos[i],"2");
	    	p.practice("3",threes[i],"3");
	    	p.practice("4",fours[i],"4");
	    	p.practice("5",fives[i],"5");
	    	p.practice("6",sixes[i],"6");
	    	p.practice("7",sevens[i],"7");
	    	p.practice("8",eights[i],"8");
	    	p.practice("9",nines[i],"9");
	    }

	}
	

}