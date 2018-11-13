package com.ckdpharm.homepage.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.core.io.FileUrlResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

/**
 * Created by minjae on 2016-04-14.
 */
@Component
@Slf4j
public class MessageUtil {

    private static MessageSourceAccessor message;

    @Resource(name = "message")
    private MessageSourceAccessor messageSourceAccessor;

    @PostConstruct
    public void init() {
        MessageUtil.message = messageSourceAccessor;
    }

    /**
     * <pre>
     * 작성일 : 2016. 4. 29.
     * 작성자 : minjae
     * 설명   : 코드에 해당하는 메시지 반환
     *
     * 수정내역(수정일 수정자 - 수정내용)
     * -------------------------------------------------------------------------
     * 2016. 4. 29. minjae - 최초생성
     * </pre>
     *
     * @param code
     *            메시지 코드
     * @return 메시지 문자열
     */
    public static String getMessage(String code) {
        try {
            return message.getMessage(code);
        } catch (Exception e) {
            return code;
        }
    }

    /**
     * <pre>
     * 작성일 : 2016. 4. 29.
     * 작성자 : minjae
     * 설명   : 코드에 해당하는 메시지에 인자를 매핑하여 반환
     *
     * 수정내역(수정일 수정자 - 수정내용)
     * -------------------------------------------------------------------------
     * 2016. 4. 29. minjae - 최초생성
     * </pre>
     *
     * @param code
     *            코드 메시지
     * @param args
     *            메시지 인자
     * @return 메시지 문자열
     */
    public static String getMessage(String code, Object[] args) {
        return message.getMessage(code, args);
    }

    /**
     * <pre>
     * 작성일 : 2018. 8. 2.
     * 작성자 : minjae
     * 설명   : 코드에 해당하는 메시지에 인자를 매핑하여 반환
     *          없으면 기본 메시지 반환
     *
     * 수정내역(수정일 수정자 - 수정내용)
     * -------------------------------------------------------------------------
     * 2018. 8. 2. minjae - 최초생성
     * </pre>
     *
     * @param code
     *            메시지 코드
     * @param args
     *            인자
     * @return 메시지 문자열
     */
    public static String getMessage(String code, String... args) {
        return message.getMessage(code, args);
    }

    public static void main(String[] args) throws IOException {
        log.info("Create Message Constant");

        String root = "C:\\storm2018\\workspace\\storm2";

        if(args.length == 1) {
            root = args[0];
        }

        Path msg = Paths.get(root, "src/main/resources/config/message/i18n/messages.yml");

        org.springframework.core.io.Resource resource = new FileUrlResource(msg.toString());
        YamlMapFactoryBean bean = new YamlMapFactoryBean();
        bean.setResources(resource);
        Map<String, Object> object = bean.getObject();
        log.debug("{}", object);


        Path path = Paths.get(root,"src/main/java/net/bellins/storm/biz", "config/constants/MessageConstant.java");
        if(!Files.exists(path.getParent())) {
            Files.createDirectory(path.getParent());
        }

        if(Files.exists(path)) {
            log.debug("delete : {}", path);
            Files.delete(path);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("package net.bellins.storm.biz.config.constants;").append("\r\n");
        sb.append("public class MessageConstant {").append("\r\n");

        for(String key : object.keySet()) {
            Object value = object.get(key);
            if(value instanceof Map) {
                appendSubMsgToSb(key, (Map<String, Object>) value, sb);
            } else {
                sb.append("\t/** ").append(value).append(" */\r\n");
                sb.append("\tpublic static final String ").append(key.replaceAll("\\.", "_")).append(" = \"").append(key).append("\";\r\n");
            }
        }

        sb.append("}");

        try(BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void appendSubMsgToSb(String key, Map<String, Object> map, StringBuilder sb) {

        for(String subKey : map.keySet()) {
            Object value = map.get(subKey);
            String combinedKey = key + "." + subKey;

            if(value instanceof Map) {
                appendSubMsgToSb(combinedKey, (Map<String, Object>) value, sb);
            } else {
                sb.append("\t/** ").append(value).append(" */\r\n");
                sb.append("\tpublic static final String ").append(combinedKey.replaceAll("\\.", "_")).append(" = \"").append(combinedKey).append("\";\r\n");
            }
        }
    }
}
