package com.mmxb.mannoprocessor;

import com.google.auto.service.AutoService;
import com.mmxb.mannolib.MAnnotation;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;

/**
 * Created by xueying on 2018/6/13.
 */

@AutoService(Processor.class)
// auto-service 会在编译时生成META-INF
public class MProcessor extends AbstractProcessor {

    private Filer mFiler;
    private String mModuleName;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mFiler = processingEnv.getFiler();

        mModuleName = processingEnv.getOptions().get("momomoduleName");
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        // 处理的注解
        Set<String> supportAnnotationTypes = new HashSet<>();
        supportAnnotationTypes.add(MAnnotation.class.getCanonicalName());
        return supportAnnotationTypes;

    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        // 支持的源码版本
        return SourceVersion.latestSupported();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnv) {

        String name = null;
        // 获取注解
        for (Element element : roundEnv.getElementsAnnotatedWith(MAnnotation.class)) {
            name = element.getAnnotation(MAnnotation.class).name();
        }

        // 生成类
        // package com.momo;
        // public final class Anno_ModuleName {
        //      public static void getAge(int age) {
        //           System.out.println("Hello value");
        //      }
        // }

        MethodSpec main = MethodSpec.methodBuilder("sayHay")
                .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                .addParameter(Integer.class, "name")
                .addStatement("$T.out.println($S)", System.class, "hay " + name)
                .build();

        TypeSpec helloWorld = TypeSpec.classBuilder("Anno" + "_" + mModuleName)
                .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                .addMethod(main)
                .build();

        JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                .build();

        try {
            javaFile.writeTo(mFiler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}

